class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        Set<String> vis = new TreeSet<>();
       // StringBuilder sb=new StringBuilder();
        pq.add(s);
        vis.add(s);
        //int prev=Integer.parseInt(s);
        String prev = s;
        while (!pq.isEmpty()) {
            String curr = pq.poll();
          //  int cur=Integer.parseInt(curr);
            if (curr.compareTo(prev) < 0) {
                prev = curr;
            }
          //  sb.append(curr);
        //    sb.append(" ");

            String add = add(new StringBuilder(curr), a);
            if (vis.add(add)) {
                pq.add(add);
            }

            String rotate = rotate(curr, b);
            if (vis.add(rotate)) {
                pq.add(rotate);
            }
        }
       // System.out.println(sb);
        //System.out.println(prev);
        return prev;
    }

    static String add(StringBuilder sb, int a) {
        for (int i = 1; i < sb.length(); i += 2) {
            sb.setCharAt(i, (char) ((sb.charAt(i) - '0' + a) % 10 + '0'));
        }
        return sb.toString();
    }

    static String rotate(String s, int b) {
        b = b % s.length(); // To avoid unnecessary rotations
        return s.substring(s.length() - b) + s.substring(0, s.length() - b);
    }
    public static void main(String[] args) {
        Solution sol=new Solution();
        String s = "5525";int a = 9, b = 2;
        System.out.println(sol.findLexSmallestString(s,a,b));
    }
}