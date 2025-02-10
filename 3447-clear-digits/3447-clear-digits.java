class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isDigit(sb.charAt(i))) {
                    flag = true;
                    solve(sb, i);
                    break;
                }
            }
        }

        return sb.toString();
    }

    private static void solve(StringBuilder sb, int ind) {
        if (ind > 0) {
            sb.delete(ind - 1, ind + 1);
        } else {
            sb.deleteCharAt(ind);
        }
    }
}