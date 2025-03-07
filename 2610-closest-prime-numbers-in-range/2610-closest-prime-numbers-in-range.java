class Solution {
    public int[] closestPrimes(int left, int right) {
       // List<Integer> list = new ArrayList<>();
        int prev = -1, curr = -1;
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        int prevDis = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (prev == -1) {
                    prev = i;
                } else {
                    curr = i;
                    int currDis = curr - prev;
                    if (currDis < prevDis) {
                        prevDis = currDis;
                        ans[0] = prev;
                        ans[1] = curr;
                    }
                    prev = curr;
                }
            }
        }
        //System.out.println(list);
        return ans;
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}