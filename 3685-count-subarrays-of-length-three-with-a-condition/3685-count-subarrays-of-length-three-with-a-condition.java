class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        for (int i = 0; i <= n - 3; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];

            if (check(first,third,second)) {
                cnt++;
            }
        }
        return cnt;
    }
    static boolean check(int a,int b,int c){
        return a+b==c/2.0;
    }
}