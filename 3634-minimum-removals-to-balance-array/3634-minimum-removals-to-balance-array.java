class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        /*

       minimum * k>=maximum
         */
        int n=nums.length,i=0;
        int mini=n;
        for (int j = 0; j < n; j++) {
            while (nums[j]>(long)nums[i]*k){
                i++;
            }
           // System.out.println(n-j+i-1);
            mini=Math.min(mini,n-j+i-1);
        }
        return mini;
    }
}