class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int high=-1;
        for(int it:nums)high=Math.max(high,it);
        int low=1,ans=-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(sod(nums,mid)<=threshold){
                ans=mid;
                high=mid-1;;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    int sod(int[]nums,int x){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum += (nums[i] + x - 1) / x;
        }
        return sum;
    }
}