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
    public void reorderList(ListNode head) {
      if (head == null || head.next == null) return;

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
            len++;
        }

        temp = head;
        for (int i = 0; i < len / 2; i++) {
            ListNode tail = stack.pop();
            tail.next = temp.next;
            temp.next = tail;
            temp = tail.next;
        }
        if (temp != null) temp.next = null;
    }
}