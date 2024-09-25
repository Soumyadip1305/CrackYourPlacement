class Solution {
    static class Pair {
        int val, ind;

        Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.val));

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new Pair(nums[i], i));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        Pair[] resultPairs = pq.toArray(new Pair[0]);
        Arrays.sort(resultPairs, Comparator.comparingInt(p -> p.ind));

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = resultPairs[i].val;
        }

        return ans;
    }
}