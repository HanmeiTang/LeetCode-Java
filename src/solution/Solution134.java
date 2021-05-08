package solution;

import java.util.*;

public class Solution134 {
}


class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

class Solution {
    public ListNode merge(List<ListNode> listOfLists) {
        // Write your solution here/.
        int k = listOfLists.size();
        Queue<ListNode> minHeap = new PriorityQueue<>(k, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.value - b.value;
            }
        });
        for (ListNode node : listOfLists) {
            minHeap.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            if (top.next != null) minHeap.offer(top.next);
            cur.next = top;
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}

/*
1 2 3 4
2 4 5 6
4 5 6 7
[0, 3]

1->heap.pop()
*/
