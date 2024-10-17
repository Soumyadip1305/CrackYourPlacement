class Solution {
    public int maximumSwap(int num) {
        char[] digit = Integer.toString(num).toCharArray();
        int[] dp = new int[10];

        for (int i = 0; i < digit.length; i++) {
            dp[digit[i] - '0'] = i;
        }

        for (int i = 0; i < digit.length; i++) {
            for (int d = 9; d > digit[i] - '0'; d--) {
                if (dp[d] > i) {
                    char temp = digit[i];
                    digit[i] = digit[dp[d]];
                    digit[dp[d]] = temp;
                    return Integer.parseInt(new String(digit));
                }
            }
        }
        return num;
    }
}