class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (check(num)) {
                cnt++;
            }
        }
        return cnt;
    }

    static boolean check(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt++;
            num /= 10;
        }
        return cnt % 2 == 0;
    }
}
