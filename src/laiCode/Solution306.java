//public class Solution306 {
//    public boolean isPalindrome(ListNode head) {
//        // corner cases
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//        // reverse
//        ListNode rev = reversed(head);
//
//        Solution29.printList(head);
//        Solution29.printList(rev);
//
//        // compare with the original
//        while (head != null) {
//            if (rev.value != head.value) {
//                return false;
//            }
//            head = head.next;
//            rev = rev.next;
//        }
//
//        return true;
//
//    }
//
//    private ListNode reversed(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        // must use iterative reverse
//        ListNode pre = null;
//        ListNode cur = head;
//
//        while (cur != null) {
//            ListNode temp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = temp;
//        }
//
//        return pre;
//    }
//
//    public static void main(String[] args) {
//        Solution306 s = new Solution306();
//        ListNode a = new ListNode(2);
//        ListNode head = a;
//
//        a.next = new ListNode(2);
//        a = a.next;
//        a.next = new ListNode(2);
//        a = a.next;
//        a.next = new ListNode(2);
//        a = a.next;
//        a.next = new ListNode(3);
//        a = a.next;
//        a.next = new ListNode(2);
//        a = a.next;
//        a.next = new ListNode(2);
//        a = a.next;
//
//        //Solution29.printList(head);
//        System.out.println(s.isPalindrome(head));
//        int val1 = a == null ? 0 : 1;
//    }
//}