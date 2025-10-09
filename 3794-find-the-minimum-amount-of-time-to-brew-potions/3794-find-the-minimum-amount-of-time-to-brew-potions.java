class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] pref = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + skill[i - 1];
        }
        long total = 0;
        for (int j = 1; j < m; j++) {
            long mx = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long cur = total + (long) mana[j - 1] * pref[i + 1] - (long) mana[j] * pref[i];
                if (cur > mx) mx = cur;
            }
            total = mx;
        }
        return total + (long) mana[m - 1] * pref[n];
    }
}