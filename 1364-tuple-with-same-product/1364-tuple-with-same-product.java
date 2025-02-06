class Solution {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int prod = nums[i] * nums[j];
                ans += count.getOrDefault(prod, 0) * 8;
                count.put(prod, count.getOrDefault(prod, 0) + 1);
            }
        }
        return ans;
    }
}