class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0])); // sort by start day
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap of end days

        int day = 1, i = 0, n = events.length, cnt = 0;
        int lastDay = 0;
        for (int[] e : events) lastDay = Math.max(lastDay, e[1]);

        while (day <= lastDay) {
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                cnt++;
            }

            day++;
        }

        return cnt;
    }
}