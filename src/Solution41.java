class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class Solution41 {
    public ListNode reorder(ListNode head) {
        // corner cases
        if (head == null || head.next == null) {
            return head;
        }

        // find the mid point, slow sit at the mid ListNode
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // split into 2 Linked Lists
        ListNode halfTwo = slow.next;
        slow.next = null; // break the link

        // recursive reverse halfTwo
        ListNode reversedHalfTwo = reversed(halfTwo);

        // merge
        ListNode i = head.next;
        ListNode j = reversedHalfTwo;

        ListNode cur = head;
        ListNode merged = head;
        boolean swit = true;

        while (i != null && j != null) {
            if (swit) {
                cur.next = j;
                cur = cur.next;
                j = j.next;
            } else {
                cur.next = i;
                cur = cur.next;
                i = i.next;
            }
            swit = !swit;
        }


        while (i != null) {
            cur.next = i;
            cur = cur.next;
            i = i.next;
        }

        while (j != null) {
            cur.next = j;
            cur = cur.next;
            j = j.next;
        }

        return merged;
    }

    private ListNode reversed(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reversed(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }


}
