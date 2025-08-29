package LinkedList;

import java.util.Scanner;

public class SingleLinkedList {

    public static Node node;

    private static void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (node == null) {
            node = newNode;
        } else {
            Node temp = node;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Node inserted at end.");
        displayList();
    }

    private static void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (node == null) {
            node = newNode;
        } else {
            newNode.next = node;
            node = newNode;
        }
        System.out.println("Node inserted at Beginning.");
        displayList();
    }

    public static void displayList() {
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


    public static void main(String[] args) {
        initializeLinkedlist();
        //Find the nth element from the end

        while (true) {
            System.out.println("Choose Operations to Perform on SingleLinkedList \n 1. Insert at End \n 2. Insert at Beginning \n 3. Insert at Mid \n 4. Delete Node \n 5. Search Node \n 6. Display List");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Insert at End");
                    System.out.println("Enter data to insert");
                    int data = sc.nextInt();
                    insertAtEnd(data);
                    break;
                case 2:
                    System.out.println("Insert at Beginning");
                    System.out.println("Enter data to insert");
                    data = sc.nextInt();
                    insertAtBeginning(data);
                    break;
                case 3:
                    System.out.println("Insert at Mid");
                    displayList();
                    System.out.println("Enter data to insert");
                    data = sc.nextInt();
                    System.out.println("Enter position ");
                    int pos = sc.nextInt();
                    insertAtMid(data, pos);

                case 4:
                    System.out.println("Delete By Index");
                    displayList();
                    System.out.println("Enter the index to delete");
                    pos = sc.nextInt();
                    deleteByPos(pos);
                    break;
                case 6:
                    displayList();
                    break;
            }
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

    private static void deleteByPos(int pos) {
        if (node == null) {
            System.out.println("List is empty.");
            return;
        }
        if (pos == 0) {
            node = node.next;
            System.out.println("Node deleted at position 0.");
        } else {
            Node temp = node;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            System.out.println("Node deleted at position " + pos + ".");
            displayList();
        }

    }

    public static void insertAtMid(int data, int position) {
        Node newNode = new Node(data);
        if (node == null || position == 0) {
            newNode.next = node;
            node = newNode;
        } else {
            Node temp = node;
            for (int i = 0; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                System.out.println("Position out of bounds. Inserting at end.");
                insertAtEnd(data);
                return;
            }
        }
        System.out.println("Node inserted at position " + position + ".");
        displayList();
    }
}
