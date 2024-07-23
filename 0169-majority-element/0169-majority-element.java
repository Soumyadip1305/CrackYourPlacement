class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int it : nums) {
            map.put(it, map.getOrDefault(it, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) > nums.length / 2) return num;
        }
        return -1;
    }
}