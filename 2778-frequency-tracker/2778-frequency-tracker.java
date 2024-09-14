class FrequencyTracker {
//Map<Integer, Integer> map;
    int[] arr;
    int[]freq;
    public FrequencyTracker() {
       // map = new HashMap<>();
        arr = new int[100001];
        freq = new int[100001];
    }

    public void add(int number) {
        //map.put(number, map.getOrDefault(number, 0) + 1);
        if (arr[number] > 0) {
            freq[arr[number]]--;
        }
        arr[number]++;
        freq[arr[number]]++;
    }


    public void deleteOne(int number) {
//        if (!map.containsKey(number)) return;
//        int cnt = map.get(number);
//        if (cnt == 1) map.remove(number);
//        else map.put(number, cnt - 1);
        if (arr[number] == 0) return;
        freq[arr[number]]--;
        arr[number]--;
        if (arr[number] > 0) {
            freq[arr[number]]++;
        }
    }

    public boolean hasFrequency(int frequency) {
        return freq[frequency] > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */