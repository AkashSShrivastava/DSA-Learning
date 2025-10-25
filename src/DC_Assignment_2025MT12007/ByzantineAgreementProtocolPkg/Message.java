package DC_Assignment_2025MT12007.ByzantineAgreementProtocolPkg;

import java.io.Serializable;
import java.util.*;

public class Message implements Serializable {
    private final String order;  // "ATTACK" or "RETREAT"
    private final int senderId;
    private final List<Integer> path;  // Track message path
    private final int round;

    public Message(String order, int senderId, int round) {
        this.order = order;
        this.senderId = senderId;
        this.path = new ArrayList<>();
        this.path.add(senderId);
        this.round = round;
    }

    public Message(String order, int senderId, List<Integer> path, int round) {
        this.order = order;
        this.senderId = senderId;
        this.path = new ArrayList<>(path);
        this.round = round;
    }

    public String getOrder() {
        return order;
    }

    public int getSenderId() {
        return senderId;
    }

    public List<Integer> getPath() {
        return new ArrayList<>(path);
    }

    public int getRound() {
        return round;
    }

    public void addToPath(int nodeId) {
        path.add(nodeId);
    }

    @Override
    public String toString() {
        return "Message{order='" + order + "', sender=" + senderId +
                ", path=" + path + ", round=" + round + "}";
    }
}

