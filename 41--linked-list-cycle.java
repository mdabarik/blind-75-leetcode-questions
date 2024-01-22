public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head; 
        while (fast != null && fast.next != null) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
} // TC: O(n), SC: O(1)
