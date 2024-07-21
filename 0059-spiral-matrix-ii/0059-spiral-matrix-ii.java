class Solution {
    public int[][] generateMatrix(int n) {
         int[][] matrix = new int[n][n];
        //List<Integer> ans = new ArrayList<>();
//        if (matrix == null || matrix.length == 0) {
//            return ans;
//        }


        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        matrix[0][0] = 1;
        int curr = 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                 matrix[top][c] = curr++;
            }
            top++;

            for (int r = top; r <= bottom; r++) {
                matrix[r][right] = curr++;
            }
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    matrix[bottom][c]=curr++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    matrix[r][left]=curr++;
                }
                left++;
            }
        }

        return matrix;
    }
}