class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        
        if (nums.length==0)return 0;
        int i = 0, j = nums.length - 1;
        long ans=0;
        while (i < j) {
           int maxi = Math.max(nums[j - 1], nums[j - 2]);
            j -= 2;
            ans+=maxi;
            i++;
        }
        return ans;
    }
}

/*

                          2 1 3 2 1 3
                          1 1 2 2 3 3 

                          1 3 3
                          1 2 2
*/