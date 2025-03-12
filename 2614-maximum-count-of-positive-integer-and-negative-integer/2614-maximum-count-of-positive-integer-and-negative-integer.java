class Solution {
    public int maximumCount(int[] nums) {
        int neg = findLastNegative(nums) + 1;
        int pos = nums.length - findFirstPositive(nums);
        return Math.max(neg, pos);
    }

    private int findFirstPositive(int[] nums) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > 0) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int findLastNegative(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < 0) l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }
}