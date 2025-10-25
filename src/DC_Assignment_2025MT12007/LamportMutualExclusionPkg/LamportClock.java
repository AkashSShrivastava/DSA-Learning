package DC_Assignment_2025MT12007.LamportMutualExclusionPkg;

public class LamportClock {
    private int timestamp;

    public LamportClock() {
        this.timestamp = 0;
    }

    public synchronized int tick() {
        return ++timestamp;
    }

    public synchronized void update(int receivedTimestamp) {
        timestamp = Math.max(timestamp, receivedTimestamp) + 1;
    }

    public synchronized int getTime() {
        return timestamp;
    }
}

