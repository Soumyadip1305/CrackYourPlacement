class Solution {
    public int countPartitions(int[] nums) {
        int sum=0;
        for (int num : nums) {
            sum += num;
        }
        int curr=0;
        int cnt=0;
        for (int i = 0; i < nums.length-1; i++) {
             curr+=nums[i+1];
             if (Math.abs(curr-(sum-curr))%2==0){
                 cnt++;
             }
        }
        return cnt;
    }
}