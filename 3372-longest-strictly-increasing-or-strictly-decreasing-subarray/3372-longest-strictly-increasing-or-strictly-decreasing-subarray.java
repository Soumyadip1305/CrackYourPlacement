class Solution {
    public int longestMonotonicSubarray(int[] nums) {
           int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            int flag = 1;
            int flag2 = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (check2(nums,j)) {
                    flag = 0;
                }
                if (check(nums,j)) {
                    flag2 = 0;
                }
                cnt++;
                if (flag == 1) {
                    ans = Math.max(ans, cnt);
                }
                if (flag2 == 1) {
                    ans = Math.max(ans, cnt);
                }
            }
        }
        return ans;
    }
     static boolean check(int[]nums,int j){
        return nums[j] >= nums[j - 1];
    }
    static boolean check2(int[]nums,int j){
        return nums[j] <= nums[j - 1];
    }
}