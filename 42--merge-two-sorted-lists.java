class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode p1 = list1, p2 = list2, curr = newHead;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curr.next = p1;
                curr = curr.next;
                p1 = p1.next;
            } else {
                curr.next = p2;
                curr = curr.next;
                p2 = p2.next;
            }
        }
        if (p1 == null) curr.next = p2;
        if (p2 == null) curr.next = p1;
        return newHead.next;
    }
} // TC: O(m + n), SC: O(1)
