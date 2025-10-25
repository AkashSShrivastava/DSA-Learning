package DC_Assignment_2025MT12007.ByzantineAgreementProtocolPkg;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ByzantineAgreementSimulation {
    private static final int BASE_PORT = 1099;

    public static void main(String[] args) {
        try {
            // Configuration
            int N = 4;  // Total nodes
            int M = 1;  // Maximum traitors (Byzantine nodes)

            System.out.println("=== Byzantine Agreement Protocol Simulation ===");
            System.out.println("Total Nodes (N): " + N);
            System.out.println("Max Traitors (M): " + M);
            System.out.println("Condition: N >= 3M + 1: " + N + " >= " +
                    (3 * M + 1) + " = " + (N >= 3 * M + 1));
            System.out.println();

            if (N < 3 * M + 1) {
                System.out.println("ERROR: Cannot achieve consensus with " +
                        N + " nodes and " + M + " traitors!");
                System.out.println("Need at least " + (3 * M + 1) + " nodes.");
                return;
            }

            // Create scenario configurations
            runScenario(N, M, 0, "ATTACK", "Loyal Commander sends ATTACK");
            System.out.println("\n" + "=".repeat(60) + "\n");

            runScenario(N, M, 0, "ATTACK",
                    "Byzantine Commander sends conflicting orders");
            System.out.println("\n" + "=".repeat(60) + "\n");

            runScenario(N, M, 2, "ATTACK",
                    "Byzantine Lieutenant (Node 2)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runScenario(int N, int M, int byzantineNode,
                                    String commanderOrder, String description)
            throws Exception {

        System.out.println("SCENARIO: " + description);
        System.out.println("-".repeat(60));

        List<General> generals = new ArrayList<>();
        List<Registry> registries = new ArrayList<>();

        // Create generals
        for (int i = 0; i < N; i++) {
            boolean isByzantine = (i == byzantineNode);
            General general = new General(i, N, M, isByzantine);
            generals.add(general);

            Registry registry = LocateRegistry.createRegistry(BASE_PORT + i);
            registry.rebind("General" + i, general);
            registries.add(registry);

            String type = isByzantine ? "BYZANTINE" : "Loyal";
            String role = (i == 0) ? "Commander" : "Lieutenant";
            System.out.println("Node " + i + ": " + role + " [" + type +
                    "] on port " + (BASE_PORT + i));
        }

        System.out.println();
        Thread.sleep(1000);

        // Connect generals to each other
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    Registry registry = LocateRegistry.getRegistry("localhost",
                            BASE_PORT + j);
                    GeneralRPC remoteGeneral = (GeneralRPC) registry.lookup(
                            "General" + j);
                    generals.get(i).addGeneral(j, remoteGeneral);
                }
            }
        }

        System.out.println("All nodes connected.\n");

        // Commander sends initial order
        generals.get(0).sendInitialOrder(commanderOrder);

        // Wait for consensus
        Thread.sleep(5000);

        // Collect and display results
        System.out.println("\n" + "=".repeat(60));
        System.out.println("CONSENSUS RESULTS:");
        System.out.println("=".repeat(60));

        Map<String, Integer> decisionCounts = new HashMap<>();
        List<String> loyalDecisions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String decision = generals.get(i).getFinalDecision();
            boolean isByz = generals.get(i).isByzantine();

            decisionCounts.put(decision,
                    decisionCounts.getOrDefault(decision, 0) + 1);

            if (!isByz) {
                loyalDecisions.add(decision);
            }

            System.out.println("Node " + i + ": " + decision +
                    (isByz ? " [BYZANTINE]" : " [LOYAL]"));
        }

        // Verify consensus among loyal nodes
        boolean consensusReached = loyalDecisions.stream()
                .distinct()
                .count() == 1;

        System.out.println("\n" + "=".repeat(60));
        System.out.println("CONSENSUS STATUS: " +
                (consensusReached ? "✓ SUCCESS" : "✗ FAILED"));

        if (consensusReached) {
            System.out.println("All loyal nodes agreed on: " +
                    loyalDecisions.get(0));
        } else {
            System.out.println("Loyal nodes have conflicting decisions!");
        }

        System.out.println("=".repeat(60));

        // Cleanup
        for (int i = 0; i < N; i++) {
            UnicastRemoteObject.unexportObject(generals.get(i), true);
            UnicastRemoteObject.unexportObject(registries.get(i), true);
        }

        Thread.sleep(1000);
    }
}
