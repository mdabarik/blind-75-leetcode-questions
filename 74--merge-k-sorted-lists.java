/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            curr.next = tmp;
            curr = tmp;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return head.next;
    }
}
