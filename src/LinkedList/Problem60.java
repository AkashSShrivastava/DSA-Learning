package LinkedList;


/**
 * Given a linked list and a value K, partition it such that all nodes less than K come before nodes greater than or equal to
 * K. You should preserve the original relative order of the nodes in each of the two partitions. For example, given 1->4->3->2->5->2 and K
 * = 3, return 1->2->2->4->3->5.
 */
public class Problem60 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(4);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(2);
        int k = 3;
        Node head = new Node(0);
        Node temp = new Node(0);
        Node dummyLesser = head;
        Node dummyGreater = temp;
        while(node!= null) {
            if(node.data >= k) {
                dummyGreater.next = new Node(node.data);
                dummyGreater = dummyGreater.next;
            }  else {
                dummyLesser.next = new Node(node.data);
                dummyLesser = dummyLesser.next;
            }
            node = node.next;
        }
        dummyLesser.next = temp.next;
        displayList(head.next);

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
