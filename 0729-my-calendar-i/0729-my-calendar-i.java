class MyCalendar {
    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    private final List<Pair> booked;

    public MyCalendar() {
        booked = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (Pair it : booked) {
            if (start < it.end && end > it.start) {
                return false;
            }
        }
        booked.add(new Pair(start, end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */