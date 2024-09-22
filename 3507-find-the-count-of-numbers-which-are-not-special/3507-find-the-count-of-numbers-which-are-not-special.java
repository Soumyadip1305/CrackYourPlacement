class Solution {
    public int nonSpecialCount(int l, int r) {
        int sqrtR = (int) Math.sqrt(r);
        sieve(sqrtR);

        Set<Integer> set = new HashSet<>();
        for (int prime : primes) {
            int num = prime * prime;
            if (num >= l && num <= r) {
                set.add(num);
            }
        }
        
        return r - l + 1 - set.size();
    }
    static List<Integer> primes;

    private static void sieve(int maxLimit) {
        boolean[] isPrime = new boolean[maxLimit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= maxLimit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxLimit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        primes = new ArrayList<>();
        for (int i = 2; i <= maxLimit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }
}