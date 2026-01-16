class Solution {
    public int minOperations(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);

    int[] arr = new int[n];
    int m = 0;
    arr[m++] = nums[0];
    for (int i = 1; i < n; i++) {
        if (nums[i] != nums[i - 1]) {
            arr[m++] = nums[i];
        }
    }

    int ans = n;
    int j = 0;

    for (int i = 0; i < m; i++) {
        while (j < m && arr[j] - arr[i] <= n - 1) {
            j++;
        }
        ans = Math.min(ans, n - (j - i));
    }

    return ans;
}
}