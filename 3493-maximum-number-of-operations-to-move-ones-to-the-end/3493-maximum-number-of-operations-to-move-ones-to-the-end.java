class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int cnt = 0;
        int ans = 0;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1' || i == n - 1) {
                if (flag || (i == n - 1 && s.charAt(n - 1) == '0')) {
                    ans += cnt;
                }
                cnt++;
                flag = false;
            } else {
                flag = true;
            }
        }

        return ans;
    }
}