class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                ans.add(matrix[top][c]);
            }
            top++;

            for (int r = top; r <= bottom; r++) {
                ans.add(matrix[r][right]);
            }
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    ans.add(matrix[bottom][c]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    ans.add(matrix[r][left]);
                }
                left++;
            }
        }

        return ans;
    }
}