class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
         if (k <= 1) return 0;

    long prod = 1;
    int i = 0, cnt = 0;

    for (int j = 0; j < nums.length; j++) {
        prod *= nums[j];

        while (prod >= k) {
            prod /= nums[i];
            i++;
        }

        cnt += j - i + 1;
    }

    return cnt;
    }
}