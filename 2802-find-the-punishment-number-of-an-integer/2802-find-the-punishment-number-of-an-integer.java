class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (check(String.valueOf(square), 0, 0, i)) {
                sum += square;
            }
        }
        return sum;
    }

    static boolean check(String s, int ind, int curr, int tar) {
        if (ind == s.length()) {
            return curr == tar;
        }
        int num = 0;
        for (int i = ind; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (curr + num > tar) break;
            if (check(s, i + 1, curr + num, tar)) return true;
        }
        return false;
    }
}