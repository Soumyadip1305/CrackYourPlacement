class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        Arrays.sort(nums);
  /*find sum that are getter than tar     */
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int sum = nums[i] + nums[j];
                int k = binarySearch(nums, j + 1, n - 1, sum);

                if (k > j) {
                    cnt += (k - j);
                }
            }
        }

        return cnt;
    }

    private static int binarySearch(int[] nums, int l, int h, int tar) {
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] < tar) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return h;
    }
}