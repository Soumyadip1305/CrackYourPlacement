class Solution {
    public int possibleStringCount(String word) {
        int cnt = 1;
        char prev = word.charAt(0);

        for (int i = 1; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (curr == prev) {
                cnt++;
            }
            prev = curr;
        }

        return cnt;
    }
}