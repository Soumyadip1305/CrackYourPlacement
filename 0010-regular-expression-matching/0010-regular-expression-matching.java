class Solution {
    public boolean isMatch(String s, String p) {
        return dp(0, 0, s, p, new HashMap<>());
    }

    private boolean dp(int i, int j, String s, String p, Map<String, Boolean> memo) {
        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);

        if (j == p.length()) return i == s.length();

        boolean firstMatch = (i < s.length() && 
                              (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        boolean ans;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            ans = dp(i, j + 2, s, p, memo) || (firstMatch && dp(i + 1, j, s, p, memo));
        } else {
            ans = firstMatch && dp(i + 1, j + 1, s, p, memo);
        }

        memo.put(key, ans);
        return ans;
    }
}