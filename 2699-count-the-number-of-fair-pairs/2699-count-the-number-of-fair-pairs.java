class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
       long cnt=0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int lowIndex = lb(nums, i + 1, lower - nums[i]);
            int highIndex = ub(nums, i + 1, upper - nums[i]);
            cnt += (highIndex - lowIndex);
        }
        return cnt;
    }

    private int lb(int[] nums, int start, int target) {
        int low = start, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int ub(int[] nums, int start, int target) {
        int low = start, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; 
    }
}