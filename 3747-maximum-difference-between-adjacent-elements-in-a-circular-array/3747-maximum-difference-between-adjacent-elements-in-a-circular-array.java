class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxi=Math.abs(nums[nums.length-1]-nums[0]);
        for(int i=1;i<nums.length;i++){
            maxi=Math.max(maxi,Math.abs(nums[i-1]-nums[i]));
        }
        return maxi;
    }
}