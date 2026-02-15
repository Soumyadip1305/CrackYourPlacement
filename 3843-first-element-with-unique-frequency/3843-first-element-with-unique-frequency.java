class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int it : nums) {
            freq.put(it, freq.getOrDefault(it, 0) + 1);
        }

        Map<Integer, Integer> freqCount = new HashMap<>();

        for (int it : freq.values()) {
            freqCount.put(it, freqCount.getOrDefault(it, 0) + 1);
        }

        for (int x : nums) {
            if (freqCount.get(freq.get(x)) == 1) {
                return x;
            }
        }

        return -1;
    }
}