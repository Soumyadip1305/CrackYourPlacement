class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
            PriorityQueue<Long> pq = new PriorityQueue<>();
            Set<Long> set = new HashSet<>();

            int[] factors = {2, 3, 5};
            pq.add(1L);
            set.add(1L);

            long num = 1;
            for (int i = 1; i <= n; i++) {
                num = pq.poll();
                for (int fact : factors) {
                    long next = num * fact;
                    if (set.add(next)) {
                        pq.add(next);
                    }
                }
            }
            return (int) num;
    }
}