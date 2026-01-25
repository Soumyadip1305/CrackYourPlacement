class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
        if(k==1)return 0;

        Arrays.sort(nums);
        int mini=nums[n-1];
        // 9 4 1 7   --->  1 4 9 7 -> 1 4, 4 9, 9 7 k=2  min(3,5,2)=2
        //                         -> 1 4 7, 4 7 9 k=3   min(6,5)=5

        for(int i=k-1;i<n;i++){
            mini=Math.min(nums[i]-nums[i-k+1],mini);

        }
        return mini;
    }
}