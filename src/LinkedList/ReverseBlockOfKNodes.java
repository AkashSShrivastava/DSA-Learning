package LinkedList;

public class ReverseBlockOfKNodes {
    Node head;

    // Method to add a new node at the front
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Method to display the list elements
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseBlockOfKNodes list = new ReverseBlockOfKNodes();
        // Example list: Push elements
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
        list.push(7);
        list.push(8);
        list.push(9);


        printList(reverseBlockOfKNodes(list.head,2));
        printList(reverseBlockOfKNodes(list.head,3));
        printList(reverseBlockOfKNodes(list.head,4));

        printList(list.head);

    }

    private static Node reverseBlockOfKNodes(Node head, int k) {
        int i=0;
        Node temp = head;
        Node node = null;
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            if(i%k == 0) {
               temp = reverseLL(temp);
               temp.next = head;
               head = head.next;
            }
            i++;
            temp = head;
            temp.next = null;
            head = next;

        }
        return head;
    }

    private static Node reverseLL(Node head) {
        return head;
    }
}

