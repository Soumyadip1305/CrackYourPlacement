class Solution {
    public int[] applyOperations(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                nums[i - 1] *= 2;
                nums[i] = 0;
            }
        }
        int ind = 0;
        for (int it : nums) {
            if (it != 0) {
                ans[ind++] = it;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return ans;
    }
}