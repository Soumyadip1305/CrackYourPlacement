class Solution {
    public int subarraySum(int[] nums, int k) {
        int curr = 0;
        int cnt = 0;
        Map<Integer, Integer> sum = new HashMap<>();
        sum.put(0, 1);
        for (int it : nums) {
            curr += it;
            if (sum.containsKey(curr - k)) {
                cnt += sum.get(curr - k);
            }
            sum.put(curr, sum.getOrDefault(curr, 0) + 1);

        }
        return cnt;
    }
}