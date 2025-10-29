class Solution {
    public int smallestNumber(int n) {
        if (isSetNumber(n)) return n;
        for (int i = n; i <n* n ; i++) {
            if (isSetNumber(i)) return i;
        }
        return -1;
    }

    static boolean isSetNumber(int n) {
        return n > 0 && ((n & (n + 1)) == 0);
    }
}