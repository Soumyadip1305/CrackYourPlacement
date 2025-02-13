class Solution {
    public int minOperations(int[] nums, int k) {
        /*
            2,11,10,1,3
            1 2 3 10 11
            4 3 10 11

   min(x, y) * 2 + max(x, y) =
     */
        int cnt=0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }
        while (pq.size() >= 2 && pq.peek() < k) {
            long x = pq.poll();
            long y = pq.poll();
            // first is always smaller than second so
           // pq.add(Math.min(x, y) * 2L + Math.max(x, y));
            pq.offer(x * 2L + y);
            cnt++;
        }
        return cnt;        
    }
}