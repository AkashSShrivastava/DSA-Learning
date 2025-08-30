package LinkedList;

public class EvenOrOddLinkedList {
    private static Node node;
    public static void main(String[] args) {
        initializeLinkedlist();
        Node jump2x = node;
        while(jump2x!=null) {
            if(jump2x.next == null) {
                System.out.println("ODD");
                return;
            }
            if(jump2x.next.next == null) {
                System.out.println("EVEN");
                return;
            }
            jump2x = jump2x.next.next;
        }
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
