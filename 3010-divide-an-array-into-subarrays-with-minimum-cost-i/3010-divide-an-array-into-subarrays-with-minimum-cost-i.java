class Solution {
    public int minimumCost(int[] nums) {
         int mini = Integer.MAX_VALUE;
    int mini2 = Integer.MAX_VALUE;

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] < mini) {
            mini2 = mini;
            mini = nums[i];
        } else if (nums[i] < mini2) {
            mini2 = nums[i];
        }
    }

    return nums[0] + mini + mini2;
}
}