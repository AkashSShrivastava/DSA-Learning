package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseLinkedListInPairs {
    private static Node node;

    public static void main(String[] args) {
        initializeList();
        //logic to reverse in pairs
        // 1->2->3->4-> null will become 2->1->4->3 -> null
        Node temp = new Node(-1);
        while(node.next!= null) {
            temp = node; //1 2 3 4 //3 4
            node = reverse(node);//2 1 3 4 null
            temp.next = node; //1 2 1 3 4 null
            if(node.next!=null)
                node= node.next.next; //3 4 null
            else
                break;
        }
        displayList(temp);
    }



    public static Node reverse(Node node) {
        //1 2 3 4 null
        Node temp = node; //1 2 3 4 null
        temp.next = null; //1
        node = node.next; //2 3 4 null
        if(node==null)
            return node;
        Node temp2 = null;
        if(node.next != null)
            temp2 = node.next.next; //3 4 null
        node.next = temp; //2 1
        node.next.next = temp2; //2 1 3 4 null
        return node;
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
