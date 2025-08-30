package LinkedList;

public class JosephusProblem {
    public static Node head;
    public static void main(String[] args) {
        intializeList();
        displayCircularList(head);
        int m = 100; //remove every 2nd person from list of n person

        while(true) {
            int k = m;
            if(head.next == head) {
                break;
            }
            while(k>1) {
                head = head.next;
                k--;
            }
            System.out.println("Removed from Circular List: " + head.next.data);
            head.next = head.next.next;
        }
        System.out.println("\n\nLast element Left in linked list is " + head.data);

    }

    public static void intializeList() {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = head;
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


/**
 * The **Josephus circle** (or Josephus problem) is a famous theoretical problem in mathematics and computer science.
 *
 * ### What is special about the Josephus circle?
 *
 * - Imagine $$N$$ people standing in a circle.
 * - Starting from some position, you count $$k$$ people and eliminate the $$k$$th person.
 * - The counting continues from the next person, again counting $$k$$ people and removing the $$k$$th person.
 * - This process keeps going around the shrinking circle until only one person remains.
 * - The problem is to find the position of the person who survives this elimination game.
 *
 * ***
 *
 * ### Why is the Josephus problem interesting?
 *
 * - It models a classic elimination game with cyclical structure.
 * - It has applications in game theory, computer algorithms, and data structures.
 * - It demonstrates efficient computational techniques involving recursion and mathematical patterns.
 * - The problem can be solved optimally using a recurrence relation.
 *
 * ***
 *
 * ### Josephus problem recursive relation:
 *
 * $$
 * J(n, k) = \begin{cases}
 * 0 & \text{if } n = 1 \\
 * (J(n-1, k) + k) \mod n & \text{if } n > 1
 * \end{cases}
 * $$
 *
 * Where:
 * - $$J(n, k)$$ is the safe position (winner) when there are $$n$$ people, counting every $$k$$th person for removal.
 * - The result is often converted from zero-based indexing to one-based indexing.
 *
 * ***
 *
 * ### Example:
 *
 * - For $$N=5, k=2$$, the survival position is 3.
 * - For $$N=7, k=3$$, the survival position is 4.
 *
 * ***
 *
 * ### In summary:
 *
 * The **Josephus circle** problem is special because it combines circular data structures, recursion, combinatorial mathematics, and offers an elegant solution to a practical counting problem involving cyclic elimination.
 *
 * It is a classical example studied widely in algorithms and competitive programming, showcasing efficient problem-solving and mathematical reasoning.[1][2][3][4]
 *
 */
