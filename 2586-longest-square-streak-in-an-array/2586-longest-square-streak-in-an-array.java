class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int ans = -1;

        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num && map.containsKey(sqrt)) {
                map.put(num, map.get(sqrt) + 1);
                ans = Math.max(ans, map.get(num));
            } else {
                map.put(num, 1);
            }
        }
        return ans;
    }
}