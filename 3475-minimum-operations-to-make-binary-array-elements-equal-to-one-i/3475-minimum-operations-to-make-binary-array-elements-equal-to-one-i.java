class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                flipThree(nums, i);
                cnt++;
            }
        }

        for (int it : nums) {
            if (check(it)) {
                return -1;
            }
        }

        return cnt;
    }
    static boolean check(int a){
        return a==0;
    }

    private void flipThree(int[] nums, int start) {
        for (int i = start; i < start + 3; i++) {
            nums[i] = nums[i] == 0 ? 1 : 0;
        }
    }
}
