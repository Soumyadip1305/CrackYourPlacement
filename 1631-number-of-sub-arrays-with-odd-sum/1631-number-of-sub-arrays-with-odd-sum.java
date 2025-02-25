class Solution {
    private static int MOD = (int) (1e9+7);
    public int numOfSubarrays(int[] arr) {
        int oddCnt = 0, evenCnt = 1;
        int pref = 0, ans = 0;

        for (int num : arr) {
            pref += num;
            if (pref % 2 == 0) {
                ans = (ans + oddCnt) % MOD;
                evenCnt++;
            } else {
                ans = (ans + evenCnt) % MOD;
                oddCnt++;
            }
        }
        return ans;
    }
}