class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int k = n - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }

        if (k >= 0) {
            int l = n - 1;
            while (nums[l] <= nums[k]) {
                l--;
            }
            swap(nums, k, l);
        }

        reverse(nums, k + 1, n - 1);
       // System.out.println(Arrays.toString(nums));
    }

    static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l++, r--);
        }
    }
     static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}