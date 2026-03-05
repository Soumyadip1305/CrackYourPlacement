class Solution {
    public int threeSumClosest(int[] nums, int target) {
          int mini = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int l=0,r=0,n=nums.length;
        for(int i=0;i<n-2;i++){
            l=i+1;r=n-1;
         //   mini=Math.min(Math.abs(sum-target),mini);
            while(l<r){
                 int sum=nums[i]+nums[l]+nums[r];
                 if (Math.abs(sum - target) < Math.abs(mini - target)) {
                    mini = sum;
                }
                if(sum==target)return target;
                else if(sum<target){
                    l++;
                }
                else if(sum>target){
                    r--;
                }
            }
        }
        return mini;
    }
}