class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[] newA = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(newA, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int freqA = map.get(a);
                int freqB = map.get(b);
                if (freqA != freqB) {
                    return freqA - freqB;
                } else {
                    return b - a;
                }
            }
        });

        return Arrays.stream(newA).mapToInt(Integer::intValue).toArray();
    }
}