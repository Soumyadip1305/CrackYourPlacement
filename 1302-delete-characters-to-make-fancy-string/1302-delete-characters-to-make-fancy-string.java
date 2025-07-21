class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                cnt = 1;
            } else {
                cnt++;
            }

            if (cnt <= 2) {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}