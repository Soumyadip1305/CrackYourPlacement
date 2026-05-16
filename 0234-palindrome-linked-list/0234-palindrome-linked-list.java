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
    public boolean isPalindrome(ListNode head) {
         Stack<ListNode> st = new Stack<>();
        ListNode dm = head;
        while (dm != null) {
            st.push(dm);
            dm = dm.next;
        }
        ListNode fast = head;
        ListNode slow = head;
//        System.out.println(slow.val);
//        System.out.println(fast.val);

        while (fast != null && fast.next != null) {
            if (!st.isEmpty()&&st.peek().val!=slow.val){
                return false;
            }
            st.pop();
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}