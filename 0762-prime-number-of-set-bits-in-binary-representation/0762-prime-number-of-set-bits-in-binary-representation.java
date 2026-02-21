class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        boolean[] prime = new boolean[33];
    prime[2] = prime[3] = prime[5] = prime[7] = true;
    prime[11] = prime[13] = prime[17] = true;
    prime[19] = prime[23] = prime[29] = prime[31] = true;

    int ans = 0;

    for (int i = left; i <= right; i++) {
        if (prime[Integer.bitCount(i)]) {
            ans++;
        }
    }

    return ans;
    }
}