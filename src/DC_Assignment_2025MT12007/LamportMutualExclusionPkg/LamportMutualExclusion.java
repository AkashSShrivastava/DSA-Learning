package DC_Assignment_2025MT12007.LamportMutualExclusionPkg;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.*;

public class LamportMutualExclusion {
    private static final int BASE_PORT = 1099;
    private static final int N = 5; // Number of nodes

    public static void main(String[] args) {
        try {
            // Create nodes
            List<Node> nodes = new ArrayList<>();
            List<Registry> registries = new ArrayList<>();

            // Initialize nodes and RMI registries
            for (int i = 0; i < N; i++) {
                Node node = new Node(i, N);
                nodes.add(node);

                Registry registry = LocateRegistry.createRegistry(
                        BASE_PORT + i
                );
                registry.rebind("Node" + i, node);
                registries.add(registry);

                System.out.println("Node " + i + " started on port " +
                        (BASE_PORT + i));
            }

            // Allow time for all registries to start
            Thread.sleep(1000);

            // Connect nodes to each other
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        Registry registry = LocateRegistry.getRegistry(
                                "localhost", BASE_PORT + j
                        );
                        NodeRPC remoteNode = (NodeRPC) registry.lookup(
                                "Node" + j
                        );
                        nodes.get(i).addRemoteNode(j, remoteNode);
                    }
                }
            }

            System.out.println("\nAll nodes connected. Starting simulation...\n");

            // Create threads for each node to request CS
            ExecutorService executor = Executors.newFixedThreadPool(N);
            List<Future<?>> futures = new ArrayList<>();

            // Randomize request timing
            Random random = new Random();

            for (Node node : nodes) {
                Future<?> future = executor.submit(() -> {
                    try {
                        // Random delay before requesting
                        Thread.sleep(random.nextInt(2000));

                        // Request CS
                        node.requestCriticalSection();
                        node.enterCriticalSection();
                        node.executeCriticalSection();
                        node.releaseCriticalSection();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                futures.add(future);
            }

            // Wait for all nodes to complete
            for (Future<?> future : futures) {
                future.get();
            }

            executor.shutdown();
            System.out.println("\nSimulation completed successfully!");

            // Cleanup
            for (int i = 0; i < N; i++) {
                UnicastRemoteObject.unexportObject(nodes.get(i), true);
                UnicastRemoteObject.unexportObject(registries.get(i), true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}