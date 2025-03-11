class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] cnt = new int[3];
        int l = 0, ans = 0;

        for (int r = 0; r < n; r++) {
            cnt[s.charAt(r) - 'a']++;

            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                ans += (n - r);
                cnt[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return ans;
    }
}