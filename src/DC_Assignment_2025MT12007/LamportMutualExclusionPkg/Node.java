package DC_Assignment_2025MT12007.LamportMutualExclusionPkg;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.*;

public class Node extends UnicastRemoteObject implements NodeRPC {
    private final int nodeId;
    private final int totalNodes;
    private final LamportClock clock;
    private final PriorityQueue<Request> requestQueue;
    private final Set<Integer> replySet;
    private final Map<Integer, NodeRPC> remoteNodes;
    private boolean inCS;
    private boolean requestingCS;

    public Node(int nodeId, int totalNodes) throws RemoteException {
        super();
        this.nodeId = nodeId;
        this.totalNodes = totalNodes;
        this.clock = new LamportClock();
        this.requestQueue = new PriorityQueue<>();
        this.replySet = new HashSet<>();
        this.remoteNodes = new ConcurrentHashMap<>();
        this.inCS = false;
        this.requestingCS = false;
    }

    public void addRemoteNode(int id, NodeRPC node) {
        remoteNodes.put(id, node);
    }

    // Request access to Critical Section
    public synchronized void requestCriticalSection() {
        requestingCS = true;
        int timestamp = clock.tick();
        Request myRequest = new Request(timestamp, nodeId);
        requestQueue.add(myRequest);

        System.out.println("Node " + nodeId + " requesting CS at time " +
                timestamp);

        // Send REQUEST to all other nodes
        for (Map.Entry<Integer, NodeRPC> entry : remoteNodes.entrySet()) {
            try {
                entry.getValue().requestCS(timestamp, nodeId);
            } catch (RemoteException e) {
                System.err.println("Failed to send request to Node " +
                        entry.getKey());
            }
        }

        // Wait for replies from all nodes
        waitForReplies();
    }

    private void waitForReplies() {
        while (true) {
            synchronized (this) {
                if (replySet.size() == totalNodes - 1 &&
                        canEnterCS()) {
                    break;
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private boolean canEnterCS() {
        if (requestQueue.isEmpty()) return false;
        Request topRequest = requestQueue.peek();
        return topRequest.getNodeId() == nodeId;
    }

    // Enter Critical Section
    public synchronized void enterCriticalSection() {
        inCS = true;
        System.out.println("Node " + nodeId + " ENTERING CS at time " +
                clock.getTime());
    }

    // Execute in Critical Section
    public void executeCriticalSection() {
        try {
            System.out.println("Node " + nodeId + " in CRITICAL SECTION");
            Thread.sleep(2000); // Simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Release Critical Section
    public synchronized void releaseCriticalSection() {
        System.out.println("Node " + nodeId + " RELEASING CS at time " +
                clock.getTime());

        inCS = false;
        requestingCS = false;

        // Remove own request from queue
        requestQueue.removeIf(r -> r.getNodeId() == nodeId);
        replySet.clear();

        int timestamp = clock.tick();

        // Send RELEASE to all nodes
        for (Map.Entry<Integer, NodeRPC> entry : remoteNodes.entrySet()) {
            try {
                entry.getValue().releaseCS(timestamp, nodeId);
            } catch (RemoteException e) {
                System.err.println("Failed to send release to Node " +
                        entry.getKey());
            }
        }
    }

    // RPC Methods
    @Override
    public synchronized void requestCS(int timestamp, int senderId)
            throws RemoteException {
        clock.update(timestamp);

        System.out.println("Node " + nodeId + " received REQUEST from Node " +
                senderId + " at time " + timestamp);

        Request incomingRequest = new Request(timestamp, senderId);
        requestQueue.add(incomingRequest);

        // Send REPLY if not requesting or if incoming request has priority
        if (!requestingCS || shouldReply(incomingRequest)) {
            try {
                remoteNodes.get(senderId).replyToRequest(clock.tick(), nodeId);
            } catch (Exception e) {
                System.err.println("Failed to send reply to Node " + senderId);
            }
        }
    }

    private boolean shouldReply(Request incomingRequest) {
        if (requestQueue.isEmpty()) return true;

        Request myRequest = requestQueue.stream()
                .filter(r -> r.getNodeId() == nodeId)
                .findFirst()
                .orElse(null);

        if (myRequest == null) return true;

        return incomingRequest.compareTo(myRequest) < 0;
    }

    @Override
    public synchronized void replyToRequest(int timestamp, int senderId)
            throws RemoteException {
        clock.update(timestamp);

        System.out.println("Node " + nodeId + " received REPLY from Node " +
                senderId);

        replySet.add(senderId);
    }

    @Override
    public synchronized void releaseCS(int timestamp, int senderId)
            throws RemoteException {
        clock.update(timestamp);

        System.out.println("Node " + nodeId + " received RELEASE from Node " +
                senderId);

        requestQueue.removeIf(r -> r.getNodeId() == senderId);
    }

    public int getNodeId() {
        return nodeId;
    }
}

