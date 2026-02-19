class Solution {
    public int countBinarySubstrings(String s) {
        int cnt = 0;
        int prev = 0, cur = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                cnt += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }
        cnt += Math.min(prev, cur);
        return cnt;
    }
}