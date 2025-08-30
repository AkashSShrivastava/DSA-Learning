package LinkedList;
public class Node {
    int data;
    Node next;

    public Node(int i) {
        this.data = i;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node setData(int data) {
        this.data = data;
        return this;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    public Node setNode(Node node) {
        this.data = node.data;
        this.next = null;
        return this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
