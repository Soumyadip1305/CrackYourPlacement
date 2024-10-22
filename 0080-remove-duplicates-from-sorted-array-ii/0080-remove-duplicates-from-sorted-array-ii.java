class Solution {
    public int removeDuplicates(int[] nums) {
         //   at most twice
        int cnt = 1, ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt <= 2) {
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }
}