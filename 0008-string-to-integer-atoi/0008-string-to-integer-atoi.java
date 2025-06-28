class Solution {
    public int myAtoi(String s) {
        
        if (s == null || s.isEmpty()) return 0;

        s = s.trim();
        int n = s.length();
        if (n == 0) return 0;

        int i = 0;
        boolean isNegative = false;

        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            isNegative = s.charAt(i) == '-';
            i++;
        }

        long ans = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {
            ans = ans * 10 + (s.charAt(i) - '0');
            if (!isNegative && ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (isNegative && -ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }

        ans = isNegative ? -ans : ans;
        return (int) ans;
    }
}