class ExamRoom {

    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    PriorityQueue<Pair> pq;
    TreeSet<Integer> seats;

    // think about the maximize distance
    int n;

    public ExamRoom(int n) {
        this.n = n;
        pq = new PriorityQueue<>((a, b) -> {
            int distA = getDist(a);
            int distB = getDist(b);
            if (distA == distB) return a.start - b.start;
            return distB - distA;
        });
        seats = new TreeSet<>();
        pq.add(new Pair(-1, n));
    }
    private int getDist(Pair p) {
        if (p.start == -1) return p.end;
        if (p.end == n) return n - 1 - p.start;
        return (p.end - p.start) / 2;
    }
    public int seat() {
//        if (seats.isEmpty()) {
//            seats.add(0);
//            return 0;
//        }
        int pos;
        Pair it = pq.poll();
        int s = it.start;
        int e = it.end;

        if (s == -1) {
            pos = 0;  // First seat
        } else if (e == n) {
            pos = n - 1;  // Last seat
        } else {
            pos = s + (e - s) / 2;  // Middle seat
        }

        seats.add(pos);
        pq.add(new Pair(s, pos));
        pq.add(new Pair(pos, e));
        return pos;
    }

    public void leave(int p) {
        Integer low = seats.lower(p);
        Integer high = seats.higher(p);
        seats.remove(p);
        // maintaining the gaps
        pq.removeIf(pair -> (low == null ? pair.start == -1 : pair.start == low) && pair.end == p
                || pair.start == p && (high == null ? pair.end == n : pair.end == high));
        pq.add(new Pair(low == null ? -1 : low, high == null ? n : high));
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */