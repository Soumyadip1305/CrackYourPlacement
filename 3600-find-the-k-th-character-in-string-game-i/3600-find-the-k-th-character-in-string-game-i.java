class Solution {
    public char kthCharacter(int k) {
         String s="a";
        while (s.length() < k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                sb.append((char) (s.charAt(i) + 1));
            }
            s = sb.toString();
        }
        //System.out.println(s);
        return s.charAt(k-1);

    }
}