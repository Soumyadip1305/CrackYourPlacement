
class Solution {
    public int primePalindrome(int n) {
        if (n <= 2) return 2;
        if (n <= 3) return 3;
        if (n <= 5) return 5;
        if (n <= 7) return 7;
        if (n <= 11) return 11;

        for (int len = 1; len < 6; len++) {
            for (int root = (int) Math.pow(10, len - 1); root < (int) Math.pow(10, len); root++) {
                String left = Integer.toString(root);
                String right = new StringBuilder(left.substring(0, left.length() - 1)).reverse().toString();
                int pal = Integer.parseInt(left + right);
                if (pal >= n && isPrime(pal)) {
                    return pal;
                }
            }
        }

        return -1;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
