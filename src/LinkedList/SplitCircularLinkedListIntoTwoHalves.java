package LinkedList;

public class SplitCircularLinkedListIntoTwoHalves {

    public static Node node;

    public static void main(String[] args) {
        initializeList();
        displayCircularList(node);
        if (node == null) {
            System.out.println("List is empty.");
            return;
        }
        Node slow = node;
        Node fast = node;
        Node mid = null;
        while (fast.next != node && fast.next.next != node) {
            slow = slow.next;
            mid = slow.next.next;
            fast = fast.next.next;
        }
        Node firstHalf = node;
        Node secondHalf = slow.next;
        slow.next = node;


        if(fast.next == node)
            fast.next = secondHalf;
        else
            fast.next.next = secondHalf;
        System.out.println("The list is split into two halfs.");
        displayCircularList(firstHalf);
        displayCircularList(secondHalf);
    }

    public static void initializeList() {
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        //node.next.next.next.next.next.next.next = new Node(8);
        node.next.next.next.next.next.next.next = node;
        //node.next.next.next.next.next.next.next.next = node;
    }

    public static void displayCircularList(Node node) {
        if (node == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = node.next;

        System.out.print("Circular Linked List: ");
        System.out.print(node.getData()+" -> ");
        while (temp != node) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("(back to head)");
    }
}
