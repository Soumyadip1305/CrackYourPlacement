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
         int len=0;
        ListNode curr=head;
        while (curr!=null){
            len++;
            curr=curr.next;
        }/*
        len=4
        n=2->3
        len-n=2 ->1->0
        */
        if (len == n) {
            return head.next;
        }
        ListNode dummy = head;

        for (int i = 1; i < len - n; i++) {
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return head;
    }
}