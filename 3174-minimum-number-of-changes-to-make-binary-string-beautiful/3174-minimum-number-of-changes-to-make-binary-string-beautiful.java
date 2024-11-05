class Solution {
    public int minChanges(String str) {
         int length = str.length();
         int ans = 0;

        for (int i = 0; i < length; i += 2) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                ans += 1;
            }
        }

        return ans;
    }
}