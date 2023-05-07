
class Solution {
    public ListNode reverse(ListNode head) {
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode head1 = head;
        
        head2 = reverse(head2);
        ListNode curr = new ListNode(-1);
        while (head1 != null) {
            ListNode tmp = head1.next;
            curr.next = head1;
            head1.next = head2;
            curr = head2;
            head1 = tmp;
            if (head2 != null) head2 = head2.next;
        }
    }
} // TC: O(n), SC: O(1)
