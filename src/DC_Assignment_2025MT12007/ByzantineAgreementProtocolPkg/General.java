package DC_Assignment_2025MT12007.ByzantineAgreementProtocolPkg;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class General extends UnicastRemoteObject implements GeneralRPC {
    private final int nodeId;
    private final int totalNodes;
    private final int maxTraitors;
    private final boolean isByzantine;
    private final Map<Integer, GeneralRPC> otherGenerals;

    // Store received messages by round and path
    private final Map<String, List<String>> receivedOrders;
    private String finalDecision;
    private CountDownLatch roundLatch;

    public General(int nodeId, int totalNodes, int maxTraitors,
                   boolean isByzantine) throws RemoteException {
        super();
        this.nodeId = nodeId;
        this.totalNodes = totalNodes;
        this.maxTraitors = maxTraitors;
        this.isByzantine = isByzantine;
        this.otherGenerals = new ConcurrentHashMap<>();
        this.receivedOrders = new ConcurrentHashMap<>();
        this.finalDecision = null;
    }

    public void addGeneral(int id, GeneralRPC general) {
        otherGenerals.put(id, general);
    }

    @Override
    public int getNodeId() throws RemoteException {
        return nodeId;
    }

    @Override
    public boolean isByzantine() throws RemoteException {
        return isByzantine;
    }

    // Commander sends initial order
    public void sendInitialOrder(String order) {
        System.out.println("Commander (Node " + nodeId + ") sending order: " +
                order + (isByzantine ? " [BYZANTINE]" : " [LOYAL]"));

        for (Map.Entry<Integer, GeneralRPC> entry : otherGenerals.entrySet()) {
            try {
                String orderToSend = order;

                // Byzantine commander sends conflicting orders
                if (isByzantine) {
                    orderToSend = (entry.getKey() % 2 == 0) ?
                            "ATTACK" : "RETREAT";
                    System.out.println("  Byzantine commander sending '" +
                            orderToSend + "' to Node " +
                            entry.getKey());
                }

                Message msg = new Message(orderToSend, nodeId, 0);
                entry.getValue().receiveOrder(msg);

            } catch (RemoteException e) {
                System.err.println("Failed to send to Node " + entry.getKey());
            }
        }
    }

    @Override
    public synchronized void receiveOrder(Message message) throws RemoteException {
        int round = message.getRound();

        System.out.println("Node " + nodeId + " received order '" +
                message.getOrder() + "' from path " +
                message.getPath() + " (round " + round + ")");

        // Store the received order
        String key = "round_" + round + "_path_" + message.getPath();
        receivedOrders.computeIfAbsent(key, k -> new ArrayList<>())
                .add(message.getOrder());

        // If not the last round, relay to others
        if (round < maxTraitors) {
            relayToOthers(message);
        }

        // If we've received all expected messages for this round
        if (round == maxTraitors) {
            // Wait a bit for all messages to arrive
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    computeFinalDecision();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }

    private void relayToOthers(Message message) {
        int nextRound = message.getRound() + 1;
        List<Integer> path = message.getPath();

        for (Map.Entry<Integer, GeneralRPC> entry : otherGenerals.entrySet()) {
            int targetId = entry.getKey();

            // Don't send back to nodes already in the path
            if (path.contains(targetId)) {
                continue;
            }

            try {
                String orderToRelay = message.getOrder();

                // Byzantine node sends conflicting information
                if (isByzantine) {
                    orderToRelay = (targetId % 2 == 0) ? "ATTACK" : "RETREAT";
                    System.out.println("  Byzantine Node " + nodeId +
                            " sending conflicting '" + orderToRelay +
                            "' to Node " + targetId);
                }

                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nodeId);
                Message relayMsg = new Message(orderToRelay,
                        message.getSenderId(),
                        newPath, nextRound);

                entry.getValue().relayOrder(relayMsg, nodeId);

            } catch (RemoteException e) {
                System.err.println("Failed to relay to Node " + targetId);
            }
        }
    }

    @Override
    public synchronized void relayOrder(Message message, int fromNode)
            throws RemoteException {
        receiveOrder(message);
    }

    private synchronized void computeFinalDecision() {
        if (finalDecision != null) {
            return;  // Already computed
        }

        System.out.println("\nNode " + nodeId + " computing final decision...");

        // Collect all received orders
        Map<String, Integer> voteCounts = new HashMap<>();
        voteCounts.put("ATTACK", 0);
        voteCounts.put("RETREAT", 0);

        for (Map.Entry<String, List<String>> entry : receivedOrders.entrySet()) {
            // Use majority for each message chain
            String majority = getMajority(entry.getValue());
            voteCounts.put(majority, voteCounts.get(majority) + 1);
        }

        // Final decision based on majority
        finalDecision = (voteCounts.get("ATTACK") >= voteCounts.get("RETREAT")) ?
                "ATTACK" : "RETREAT";

        System.out.println("Node " + nodeId + " FINAL DECISION: " +
                finalDecision +
                " (ATTACK votes: " + voteCounts.get("ATTACK") +
                ", RETREAT votes: " + voteCounts.get("RETREAT") + ")" +
                (isByzantine ? " [BYZANTINE NODE]" : " [LOYAL NODE]"));
    }

    private String getMajority(List<String> orders) {
        Map<String, Integer> counts = new HashMap<>();
        for (String order : orders) {
            counts.put(order, counts.getOrDefault(order, 0) + 1);
        }

        int attackCount = counts.getOrDefault("ATTACK", 0);
        int retreatCount = counts.getOrDefault("RETREAT", 0);

        // Default to RETREAT in case of tie
        return (attackCount > retreatCount) ? "ATTACK" : "RETREAT";
    }

    @Override
    public String getFinalDecision() throws RemoteException {
        // Wait for decision if not yet computed
        int maxWait = 50;  // 5 seconds max
        while (finalDecision == null && maxWait > 0) {
            try {
                Thread.sleep(100);
                maxWait--;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return finalDecision != null ? finalDecision : "UNDECIDED";
    }
}

