package DC_Assignment_2025MT12007.LamportMutualExclusionPkg;

import java.io.Serializable;
import java.util.Objects;

public class Request implements Serializable, Comparable<Request> {
    private final int timestamp;
    private final int nodeId;

    public Request(int timestamp, int nodeId) {
        this.timestamp = timestamp;
        this.nodeId = nodeId;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getNodeId() {
        return nodeId;
    }

    @Override
    public int compareTo(Request other) {
        if (this.timestamp != other.timestamp) {
            return Integer.compare(this.timestamp, other.timestamp);
        }
        return Integer.compare(this.nodeId, other.nodeId);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Request)) return false;
        Request other = (Request) obj;
        return this.timestamp == other.timestamp &&
                this.nodeId == other.nodeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, nodeId);
    }
}

