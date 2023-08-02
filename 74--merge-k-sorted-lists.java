class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        int interval = 1;
        while (interval < n) { // O(log k)
            for (int i = 0; i + interval < n; i = i + interval * 2) {
                lists[i] = mergeTwoSortedLists(lists[i], F[i + interval]); // O(n)
            }
            interval = 2 * interval;
        }
        return lists[0];
    }
    public ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }
        if (list1 == null) curr.next = list2;
        if (list2 == null) curr.next = list1;
        return head.next;
    }
} // TC: O(n * log k) , SC: O(1)
