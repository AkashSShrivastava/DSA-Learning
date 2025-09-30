package Recursion;

/**
 * Merge the two lists into one sorted list.
 * The list should be made by splicing together
 * the nodes of the first two lists.
 */
public class MergeSortedLists {

    public static void add(ListNode list1, int element) {
        ListNode temp = null;
        if(list1 == null)
            return;

        while (list1.next != null) {
            if(list1.next.val > element) {
                temp = list1.next;
                list1.next = new ListNode(element);
                list1.next.next = temp;
                break;
            }
            list1 = list1.next;
        }
        return;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2 == null) {
            return list1;
        }
        add(list1, list2.val);
        mergeTwoLists(list1, list2.next);
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        mergeTwoLists(l1,new ListNode(2));
        System.out.println(l1);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
