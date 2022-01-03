public class Solution29 {
    public ListNode mergeSort(ListNode head) {
        // corner cases
        if (head == null || head.next == null) {
            return head;
        }

        // split a Linked List into two
        ListNode mid = findMid(head);
        ListNode secondHalf = mid.next;
        mid.next = null;

        // Recrisive merge sort
        ListNode right = mergeSort(secondHalf);
        ListNode left = mergeSort(head);

        // merge
        return merge(left, right);

    }

    private ListNode findMid(ListNode node) {
        // corner cases
        if (node == null || node.next == null) {
            return node;
        }

        ListNode fast = node;
        ListNode slow = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    // merge two sorted Linked List
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0); // moving dummy head
        ListNode head = dummy; // fixed dummy head

        ListNode curA = a;
        ListNode curB = b;

        while (curA != null && curB != null) {
            if (curA.value < curB.value) {
                dummy.next = curA;
                curA = curA.next;
            } else {
                dummy.next = curB;
                curB = curB.next;
            }
            dummy = dummy.next;
            System.out.println(dummy.value);
        }

        // post processing
        if (curA != null) {
            dummy.next = curA;
        } else {
            dummy.next = curB;
        }

        return head.next;
    }

    public static void printList(ListNode x) {
        while (x != null) {
            System.out.print(x.value);
            System.out.print(", ");
            x = x.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Solution29 s = new Solution29();
        ListNode a = new ListNode(1);
        a.next = new ListNode(7);
        a.next.next = new ListNode(9);

        ListNode b = new ListNode(2);
        b.next = new ListNode(5);
        b.next.next = new ListNode(6);

        ListNode c = s.merge(a, b);
        s.printList(c);
    }
}