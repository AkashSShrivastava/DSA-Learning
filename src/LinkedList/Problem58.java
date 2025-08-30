package LinkedList;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of
 * their nodes contain a single digit. Add the two numbers and return it as a linked list. For example with input: (3 -> 4 -> 3) + (5 -> 6 -> 4);
 * the output should be 8 -> 0 -> 8.
 */
public class Problem58 {

    public static void main(String[] args) {
        Node list1 = new Node(3); list1.next = new Node(4); list1.next.next = new Node(3);
        Node list2 = new Node(5); list2.next = new Node(6); list2.next.next = new Node(4);
        Node node = new Node(0);
        Node temp = new Node(1);
        node.next = temp;
        int sum; int carry = 0;
        while(list1 != null || list2 != null) {
            assert list1 != null;
            sum = list1.data + list2.data + carry;
            carry = sum / 10;
            sum = (sum % 10);


            temp.next = new Node(sum);
            temp = temp.next;
            list2 = list2.next;
            list1 = list1.next;
        }

        displayList(node.next.next);


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
