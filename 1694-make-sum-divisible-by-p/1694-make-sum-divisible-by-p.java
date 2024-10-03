class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        long sum=0;
        for (int it:nums){
            sum+=it;
        }
        //System.out.println(sum);
        if (sum % p == 0) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        long prefixSum = 0;
        int mini = n;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            long rem = prefixSum % p;
            long findRem = (rem - (sum % p) + p) % p;

            if (map.containsKey(findRem)) {
                mini = Math.min(mini, i - map.get(findRem));
            }

            map.put(rem, i);
        }
       // System.out.println(mini);
       // System.out.println(map);
        return mini == n ? -1 : mini;
    }
}