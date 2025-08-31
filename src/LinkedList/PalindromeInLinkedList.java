package LinkedList;

public class PalindromeInLinkedList {
    Node head;

    // Method to add a new node at the front
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Method to display the list elements
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to check if the linked list is palindrome
    private boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        // Find midpoint
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node firstHalf = head;
        Node secondHalf = slow.next;
        slow.next = null;

        // Reverse second half
        secondHalf = reverseLL(secondHalf);

        // Compare both halves
        Node p1 = firstHalf;
        Node p2 = secondHalf;
        while (p2 != null) {
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Optional: Restore the original list structure
        slow.next = reverseLL(secondHalf);

        return true;
    }

    // Helper function to reverse a linked list
    public Node reverseLL(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        PalindromeInLinkedList list = new PalindromeInLinkedList();
        // Example list: Push elements
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(2);
        list.push(1);

        list.printList(list.head);
        System.out.println("Is palindrome? " + list.isPalindrome());
    }
}
