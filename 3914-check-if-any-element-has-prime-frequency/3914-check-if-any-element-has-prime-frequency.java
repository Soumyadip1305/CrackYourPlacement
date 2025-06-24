class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for (int it:nums){
            map.put(it,map.getOrDefault(it,0)+1);
        }
        for (int it:map.values()){
            if (isPrime(it))return true;
        }
        return false;
    }
    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}