class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i = 0, j = 0;
        int cnt = 0;
        int total = 0;
        int prev = 0;
        while (j < nums.length) {
            if (nums[j] % 2 != 0) {
                cnt++;
                prev = 0; // reset
            }
            while (cnt == k) {
                if (nums[i] % 2 != 0) {
                    cnt--;
                }
                prev++;
                i++;
            }

            total += prev; // Add the number of valid subarrays ending at `j`
            j++;
        }

        return total;
    }
}