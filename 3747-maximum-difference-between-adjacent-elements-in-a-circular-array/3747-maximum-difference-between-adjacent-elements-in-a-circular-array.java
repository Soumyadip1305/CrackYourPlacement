class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxi=Math.abs(nums[nums.length-1]-nums[0]);
        for(int i=1;i<nums.length;i++){
           int diff = Math.abs(nums[i] - nums[i - 1]);
            if (Math.abs(nums[i] - nums[i - 1]) > maxi) {
                maxi = diff;
            }                
        }
        return maxi;
    }
}