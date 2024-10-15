class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        long one = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                ans += one;
            } else {
                one++;
            }
        }

        return ans;
    }
}