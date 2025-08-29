package LinkedList;

public class FindElementFromEndInLinkedList {

    public static Node node;


    public static void main(String[] args) {
        initializeLinkedlist();
        displayList();

        findNElementFromEndBF(3);
        findNElementFromEnd2Pointer(3);
        findNElementFromEndBF(9);
        findNElementFromEnd2Pointer(9);
        findNElementFromEndBF(10);
        findNElementFromEnd2Pointer(10);
    }

    private static void findNElementFromEnd2Pointer(int index) {
        System.out.println( "findNElementFromEnd2Pointer");
        if (node == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = node;
        Node slow = node;
        for(int i=0;i<index;i++){
            temp = temp.next;
            if(temp==null) {
                System.out.println("List is not long enough.");
                return;
            }
        }
        while(temp != null){
            temp = temp.next;
            slow = slow.next;
            if(slow == null){
                System.out.println("List is not long enough.");
                return;
            }
        }

        System.out.println("Element at index " + index + " (from end) is " + slow.data);
    }




    private static void findNElementFromEndBF(int index) {
        if (node == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = node;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        System.out.println("size of linked list is " + size);
        if(index > size){
            System.out.println("Index cant be greater than size of linked list.");
            return;
        }

        int indexFromStart = size - index;
        temp = node;
        for(int i=0;i<indexFromStart;i++){
            temp = temp.next;
        }
        System.out.println("Element at index " + indexFromStart + " is " + temp.data);
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
}
