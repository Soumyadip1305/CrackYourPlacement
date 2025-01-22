class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int it : nums) {
            pq.add(it);
        }
        while (k - 1 > 0 && !pq.isEmpty()) {
            pq.poll();
            k--;
        }
//        System.out.println(pq);
//        System.out.println(pq);
        return pq.poll();
    }
}