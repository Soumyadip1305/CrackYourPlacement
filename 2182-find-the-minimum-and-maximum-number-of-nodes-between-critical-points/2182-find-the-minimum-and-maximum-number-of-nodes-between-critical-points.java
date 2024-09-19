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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        List<Integer> list = new ArrayList<>();
        ListNode curr = head.next;
        ListNode prev = head;
        ListNode next = head.next.next;
        int pos = 1;
        while (next != null) {
            if (curr.val > prev.val && curr.val > next.val ||
                    curr.val < prev.val && curr.val < next.val) {
                list.add(pos);
            }
            prev=curr;
            curr=next;
            next=next.next;
            head=head.next;
            pos++;
        }
        if (list.size()<2){
            return new int[]{-1, -1};
        }
        //Collections.sort(list);
        int mini = Integer.MAX_VALUE;
        int maxi = list.get(list.size() - 1) - list.get(0);
        for (int i = 1; i < list.size(); i++) {
            mini = Math.min(mini, list.get(i) - list.get(i - 1));
        }
        return new int[]{mini,maxi};
    }
}