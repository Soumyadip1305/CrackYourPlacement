class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (nums.get(i) % modulo == k) nums.set(i, 1);
            else nums.set(i, 0);
        }

        Map<Integer, Long> map = new HashMap<>();
        int sum = 0;
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            sum = (sum + nums.get(i)) % modulo;
            if (sum == k) cnt++;

            int rem = sum - k;
            if (rem < 0) rem += modulo;

            cnt += map.getOrDefault(rem, 0L);
            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }

        return cnt;
    }
}