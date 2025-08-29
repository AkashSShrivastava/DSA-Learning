package LinkedList;

public class CircularLinkedList {
    private static Node node;

    private static void initializeCircilarlinkedlist() {
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        node.next.next.next.next.next.next.next.next = new Node(9);
        node.next.next.next.next.next.next.next.next.next = node;
        //This will create the circular linked list
    }

    private static void displayList() {
        if (node == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = node.next;
        System.out.print(node.getData() + " -> ");
        while (temp != node) {
            if (temp == null) {
                System.out.println("null");
                return;
            }
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();

        }
    }

    public static void main(String[] args) {
        initializeCircilarlinkedlist();
        displayList();

        checkIfCircular();

    }

    private static void checkIfCircular() {
        if (node == null) {
            System.out.println("List is empty.");
            return;
        }
        Node slow = node;
        Node fast = node.next;
        while (slow != fast) {
            if (slow == null || fast == null) {
                System.out.println("List is not Circular");
                return;
            }

                slow = slow.getNext();
                fast = fast.getNext().getNext();
        }
        System.out.println("List is Circular");
    }
}
