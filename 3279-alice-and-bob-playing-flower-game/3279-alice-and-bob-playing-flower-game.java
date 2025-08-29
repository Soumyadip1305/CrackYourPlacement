class Solution {
    public long flowerGame(int n, int m) {
        long oCN = sum(n), oCM = sum(m), eCN = half(n), eCM = half(m);
        long k = oCN * eCM;
        long g = eCN * oCM;
        return g + k;
    }

    private static long sum(int n) {
        return (n + 1) / 2;
    }

    private static long half(int n) {
        return n / 2;
    }
}