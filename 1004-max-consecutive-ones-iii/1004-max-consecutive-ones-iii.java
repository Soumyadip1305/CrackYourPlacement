class Solution {
    public int longestOnes(int[] nums, int k) {
        int sum=0;
        int i = 0, maxi = 0;

        for (int j = 0; j < nums.length; j++) {

            sum+=nums[j];

            while ((j - i + 1) - sum > k) {
                sum-=nums[i];
                i++;
            }

            maxi = Math.max(maxi, j - i + 1);
        }

        return maxi;
    }
}