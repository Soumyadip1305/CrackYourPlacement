class Solution {
    static class Pair {
        int val;
        int freq;

        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
         int[] ans = new int[barcodes.length];
        Map<Integer, Integer> freq = new HashMap<>();

        for (int it : barcodes) {
            freq.put(it, freq.getOrDefault(it, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int i = 0;
        Pair prev = new Pair(-1, 0);

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            ans[i++] = curr.val;

            if (prev.freq > 0) {
                pq.add(prev);
            }

            curr.freq--;
            prev = curr;
        }

        return ans;
    }
}