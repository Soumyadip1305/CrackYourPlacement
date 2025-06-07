class Solution {
    public String clearStars(String s) {
         char[] chars = s.toCharArray();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        calculatePQ(chars,pq);
        return calculateAns(chars);
    }
    static void calculatePQ(char[] chars,PriorityQueue<int[]> pq){
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != '*') {
                pq.offer(new int[]{c - 'a', i});
            } else {
                int[] t = pq.poll();
                chars[Objects.requireNonNull(t)[1]] = '-';
            }
        }
    }
    static String  calculateAns(char[] chars){
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '-' && c != '*') sb.append(c);
        }
        return sb.toString();
    }
}