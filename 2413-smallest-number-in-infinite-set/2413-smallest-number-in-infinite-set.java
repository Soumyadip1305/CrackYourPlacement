class SmallestInfiniteSet {
PriorityQueue<Integer> pq;
    int curr;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        curr = 1;
    }

    public int popSmallest() {
        if (!pq.isEmpty() && pq.peek() < curr) {
            return pq.poll();
        } else
            return curr++;
    }

    public void addBack(int num) {
        if (num < curr && !pq.contains(num)) {
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */