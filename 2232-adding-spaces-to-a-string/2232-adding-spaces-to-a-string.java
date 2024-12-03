class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        int sp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (sp < spaces.length &&i == spaces[sp]) {
                ans.append(" ");
                sp++;
            }
            ans.append(chars[i]);
        }
        return ans.toString();
    }
}