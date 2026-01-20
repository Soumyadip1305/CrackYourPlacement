class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = findAns(nums.get(i));
        }
        return ans;
    }

    public static int findAns(int num) {
         if (num==2)return -1;
        int ans = num;
        int ind = 0;

        while ((num & 1) == 1) {
            num >>= 1;
            ans ^= (1 << ind);
            ind++;
        }

        return ans | ((1 << (ind - 1)) - 1);
    }
}