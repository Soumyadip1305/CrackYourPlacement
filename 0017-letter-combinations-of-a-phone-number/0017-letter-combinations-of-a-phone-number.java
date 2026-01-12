class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        String[] map = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        solve(0, digits, "", list, map);
        return list;
    }

    private static void solve(int ind, String digits, String curr, List<String> ans, String[] map) {
        if (ind == digits.length()) {
            ans.add(curr);
            return;
        }
        String letter = map[digits.charAt(ind) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            solve(ind + 1, digits, curr + letter.charAt(i), ans, map);
        }
    }
}