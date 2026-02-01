class Solution {
    public int minimumCost(int[] nums) {
        int mini=Integer.MAX_VALUE;
        int miniInd=-1;
        int mini2=Integer.MAX_VALUE;

        for(int i=1;i<nums.length;i++){
            if(mini>nums[i]){
                mini=nums[i];
                miniInd=i;
            }
        }
        for(int i=1;i<nums.length;i++){
            if(miniInd!=i){
            mini2=Math.min(mini2,nums[i]);
        }
        }
        return mini+mini2+nums[0];
    }
}