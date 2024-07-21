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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix =new int[m][n];
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        ListNode curr = head;
        while (curr != null && top <= bottom && left <= right) {
            for (int c = left; c <= right && curr != null; c++, curr = curr.next) {
                matrix[top][c] = curr.val;
            }
            top++;
            for (int r = top; r <= bottom && curr != null; r++, curr = curr.next) {
                matrix[r][right] = curr.val;
            }
            right--;
            for (int c = right; c >= left && curr != null; c--, curr = curr.next) {
                matrix[bottom][c] = curr.val;
            }
            bottom--;
            for (int r = bottom; r >= top && curr != null; r--, curr = curr.next) {
                matrix[r][left] = curr.val;
            }
            left++;
        }

        return matrix;
    }
}