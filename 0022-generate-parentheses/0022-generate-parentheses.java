class Solution {
    public List<String> generateParenthesis(int n) {
         /*

        I should track open and close parentheses
         For each pair of parentheses, you have two options:
         open a new parenthesis or close an existing open parenthesis.
         So, you'll recursively
         generate combinations by trying both options for each parenthesis.
         */
        List<String> ans = new ArrayList<>();
        solve(n, 0, 0, ans, new StringBuilder());
        return ans;
    }

    private static void solve(int n, int open, int close, List<String> ans, StringBuilder sb) {

        if (open==n&&close==n){
            ans.add(sb.toString());
            return;
        }
        // open a new paren
        if (open < n) {
            sb.append("(");
            solve(n, open + 1, close, ans, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        // closed existing paren
        if (close < open) {
            sb.append(")");
            solve(n, open, close + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
}