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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;

        // Step 1: Calculate length
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        if (n == len) return head.next;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        temp = head;
        for (int i = 0; i < len - n; i++) {
            curr.next = new ListNode(temp.val);
            curr = curr.next;
            temp = temp.next;
        }
        temp = temp.next;

        while (temp != null) {
            curr.next = new ListNode(temp.val);
            curr = curr.next;
            temp = temp.next;
        }
       // printList(dummy);
        return dummy.next;
    }
}