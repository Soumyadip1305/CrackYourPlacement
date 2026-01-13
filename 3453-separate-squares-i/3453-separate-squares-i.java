class Solution {
    public double separateSquares(int[][] squares) {
        return Bs(squares);
    }
    public static double Bs(int[][] squares) {
        double low = 0, high = 1e18;
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2;
            double above = calculateAbove(squares, mid);
            double below = calculateBelow(squares, mid);
            if (above > below) low = mid;
            else high = mid;
        }
        return low;
    }

    private static double calculateAbove(int[][] squares, double y) {
        double area = 0;
        for (int[] square : squares) {
            int yi = square[1];
            int li = square[2];
            if (yi + li > y) {
                double height = Math.min(yi + li - y, li);
                area += height * li;
            }
        }
        return area;
    }

    private static double calculateBelow(int[][] squares, double y) {
        double area = 0;
        for (int[] square : squares) {
            int yi = square[1];
            int li = square[2];
            if (yi < y) {
                double height = Math.min(y - yi, li);
                area += height * li;
            }
        }
        return area;
    }
}