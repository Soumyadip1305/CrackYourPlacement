class Solution {
    public int[] applyOperations(int[] nums) {
        int ind=0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 &&nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
            if (nums[i] != 0) {
                nums[ind++] = nums[i];
            }
        }
        Arrays.fill(nums,ind,nums.length,0);
        return nums;
    }
}