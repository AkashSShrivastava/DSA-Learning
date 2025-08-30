package LinkedList;

public class MergeTwoLinkedList {
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node head = new Node(-1);
        Node newHead = new Node(0);
        head.next = newHead;
        while (l1 != null && l2 != null) {
            if (l1 == null) {
                newHead.next = l2;
            }
            if (l2 == null) {
                newHead.next = l1;
            }
            if (l1.data < l2.data) {
                newHead.next = new Node(l1.data);
                newHead = newHead.next;
                l1 = l1.next;
            }
            if (l2.data < l1.data) {
                newHead.next = new Node(l2.data);
                newHead = newHead.next;
                l2 = l2.next;
            }
        }
        return head.next.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);
        l1.next.next.next = new Node(7);
        l1.next.next.next.next = new Node(10);
        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);
        displayList(mergeTwoLists(l1, l2));
    }

    public static void displayList(Node node) {
        if (node == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = node;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
