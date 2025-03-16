class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            long timeTaken = totalTakeTime(mid, piles);
            if (timeTaken <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static long totalTakeTime(int x, int[] arr) {
        long ans = 0;
        for (int j : arr) {
            ans += (int) Math.ceil((double) j / x);
        }
        return ans;
    }
}