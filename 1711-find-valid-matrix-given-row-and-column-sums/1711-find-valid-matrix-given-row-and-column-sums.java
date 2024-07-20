class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int numRows = rowSum.length;
        int numCols = colSum.length;
        int[][] matrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int minVal = Math.min(rowSum[i], colSum[j]);// Find the minimum value that can be placed in matrix[i][j]
                matrix[i][j] = minVal;
                
                rowSum[i] -= minVal;// Update the row and column sums
                colSum[j] -= minVal;
            }
        }

        return matrix;
    }
}