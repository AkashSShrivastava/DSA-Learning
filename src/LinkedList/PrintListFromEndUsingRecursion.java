package LinkedList;

public class PrintListFromEndUsingRecursion {
    private static Node node;

    public static void main(String[] args) {
        initializeLinkedlist();
        printNode(node);
    }

    private static void printNode(Node head) {
        if(head == null) {
            return;
        }
        printNode(head.next);
        System.out.println(head.data);
    }

    private static void initializeLinkedlist() {
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        node.next.next.next.next.next.next.next.next = new Node(9);
    }
}
