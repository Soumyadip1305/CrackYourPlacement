class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        long minSum = Long.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums.get(j);
                int size = j - i + 1;
                
                if (size >= l && size <= r && sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }
        
        return (minSum == Long.MAX_VALUE) ? -1 : (int) minSum;
    }
}