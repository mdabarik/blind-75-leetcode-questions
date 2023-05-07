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
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        return reverse(head, null); // head, newHead
    }
    private ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }
} // TC: O(n), SC: O(n)


class Solution {
    ListNode newHead = null;
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        reverse(head);
        return newHead;
    }
    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            newHead = head;
            return head;
        }
        ListNode tmp = reverse(head.next);
        tmp.next = head;
        head.next = null;
        return head;
    }
} // TC: O(n), SC: O(n)
