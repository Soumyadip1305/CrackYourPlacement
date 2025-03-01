class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                nums[i - 1] *= 2;
                nums[i] = 0;
            }
        }
        int ind = 0;
        for (int it : nums) {
            if (it != 0) {
                nums[ind++] = it;
            }
        }
        while (ind < nums.length) {
            nums[ind++] = 0;
        }
        return nums;
    }
}