class Solution {
    public long kMirror(int k, int n) {
        long ans = 0;
        int curr = 0;
        int len = 1;

        while (curr < n) {
            for (int half = (int)Math.pow(10, len - 1); curr < n && half < (int)Math.pow(10, len); half++) {
                long num = buildPalindrome(half, true);
                if (isPalindrome(toBaseK(num, k))) {
                    ans += num;
                    curr++;
                }
            }
            for (int half = (int)Math.pow(10, len - 1); curr < n && half < (int)Math.pow(10, len); half++) {
                long num = buildPalindrome(half, false);
                if (isPalindrome(toBaseK(num, k))) {
                    ans += num;
                    curr++;
                }
            }
            len++;
        }
        return ans;
    }

    private static long buildPalindrome(int half, boolean odd) {
        StringBuilder sb = new StringBuilder();
        sb.append(half);
        int start = odd ? sb.length() - 2 : sb.length() - 1;
        for (int i = start; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static String toBaseK(long num, int k) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }
}