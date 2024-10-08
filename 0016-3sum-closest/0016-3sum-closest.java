class Solution {
    public int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
        int n = nums.length, closest = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
               // int diff = Math.abs(sum - target);
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return sum;
                }
            }
        }

        return closest;
    }
}