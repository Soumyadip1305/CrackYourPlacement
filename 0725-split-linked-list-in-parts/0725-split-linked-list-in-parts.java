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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int len = 0;
        ListNode dummy = head;
        while (dummy != null) {
            len++;
            dummy = dummy.next;
        }
        int partSize = len / k;
        int extra = len % k;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ans[i] = curr;
            int curPartSize = partSize + (extra > 0 ? 1 : 0);
            extra--;
            for (int j = 1; j < curPartSize && curr != null; j++) {
                curr = curr.next;
            }

            if (curr != null) {
                ListNode temp = curr.next;
                curr.next = null;
                curr = temp;
            }
        }

        return ans;
    }
}