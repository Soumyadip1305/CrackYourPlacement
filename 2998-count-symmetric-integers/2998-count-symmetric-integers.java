class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;

        for (int i = low; i <= high; i++) {
            if (checkSymmetric(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    private static boolean checkSymmetric(int num) {
        String str = Integer.toString(num);

        if (str.length() % 2 != 0) {
            return false;
        }
        int n = str.length() / 2;
        int sum1 = 0;
        int sum2 = 0;

        for (int j = 0; j < n; j++) {
            sum1 += str.charAt(j) - '0';
        }

        for (int j = n; j < str.length(); j++) {
            sum2 += str.charAt(j) - '0';
        }

        return sum1 == sum2;
    }
}