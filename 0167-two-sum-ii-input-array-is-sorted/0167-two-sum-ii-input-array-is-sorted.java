class Solution {
    public int[] twoSum(int[] num, int tar) {
        int l=0,r=num.length-1;
        while(l<r){
            int sum=num[l]+num[r];
            /*if(nums[l]==nums[r]){
                l++;
            } no need
            */
            if(sum==tar){
                return new int[]{l+1,r+1};
            }
            else if(sum>tar){
                r--;
            }else{
                l++;
            }
        }
        return new int[]{l+1,r+1};
    }
}