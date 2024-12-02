class Solution {
    public int minOperations(int n) {
        int cnt = 0;
        while (n != 0) {
            int log = solve(n);
            n = Math.abs(n - (int) Math.pow(2, log));
            cnt++;
        }

        return cnt;
    }

    public static int solve(int N) {
        return (int) Math.round(Math.log(N) / Math.log(2));
    }
}