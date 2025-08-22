class Solution {
     private int[] findMinMaxCoordinates(int[][] grid) {
        int minR = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE, maxC = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i < minR) minR = i;
                    if (i > maxR) maxR = i;
                    if (j < minC) minC = j;
                    if (j > maxC) maxC = j;
                }
            }
        }
        return new int[]{minR, maxR, minC, maxC};
    }

    private int[] calculateDimensions(int minRow, int maxRow, int minCol, int maxCol) {
        int h = maxRow - minRow + 1;
        int w = maxCol - minCol + 1;
        return new int[]{h, w};
    }
    public int minimumArea(int[][] grid) {
        int[] cord = findMinMaxCoordinates(grid);

        int[] arr = calculateDimensions(cord[0], cord[1], cord[2], cord[3]);
        int h = arr[0];
        int w = arr[1];

        return h * w;
    }
}