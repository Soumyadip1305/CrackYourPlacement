class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[]diff=new int[n+1];
        // sub 1 at l and 1 at r+1;
        for(int []it:queries){
            int l=it[0];
            int r=it[1];
           diff[l] -= 1;
            if (r + 1 < n) {
                diff[r + 1] += 1;
            }
        }
        System.out.println(Arrays.toString(diff));
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=diff[i];
            nums[i]+=sum;
            if(nums[i]>0)return false;
        }
        System.out.println(Arrays.toString(nums));
        return true;
    }
}