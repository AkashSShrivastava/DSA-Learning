package LinkedList;

public class MiddleOfLinkedList {
    private static Node node;

    public static void main(String[] args) {
        initializeLinkedlist();
        Node slow = node;
        Node fast = node;

        while(fast!=null) {
            if(fast.next!=null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;
            }
        }

        System.out.println( "Middle of Linked List is " + slow);
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
