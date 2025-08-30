package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseLinkedListInPairs {
    private static Node node;

    public static void main(String[] args) {
        initializeList();
        //logic to reverse in pairs
        // 1->2->3->4-> null will become 2->1->4->3 -> null
        Node newNode = node.next;
        Node prev = null;
        while(node!= null) {
            Node second = node.next;
            Node first = node;
            if(second==null) {
                second=first;
                node = null;
            } else {
                Node n3 = node.next.next;
                second.next = first;
                first.next = n3;
                node = n3;
            }
        }

        displayList(newNode);
    }


    public static Node reverseInPairs(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = head.next;
        Node prev = null;
        while (head != null && head.next != null) {
            Node nextPair = head.next.next;
            Node second = head.next;
            second.next = head;
            head.next = (nextPair != null && nextPair.next != null) ? nextPair.next : nextPair;
            if (prev != null) prev.next = second;
            prev = head;
            head = nextPair;
        }
        return newHead;
    }

    public static void initializeList() {
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
