class Solution {
    static class Pair {
        int val;
        int ind;

        Pair(int value, int index) {
            this.val = value;
            this.ind = index;
        }
    }
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxi = dp[0];
//        for (int i = 1; i < n; i++) {
//            dp[i] = nums[i];
//            for (int j = i - 1; j >= Math.max(0, i - k); j--) {
//                dp[i] = Math.max(dp[i], nums[i] + dp[j]);
//            }
//            maxi = Math.max(maxi, dp[i]);
//        }

      //  store Pair(dp[j], j), sorted by dp[j] in descending order
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        pq.add(new Pair(Math.max(dp[0], 0), 0));
        for (int i = 1; i <n ; i++) {

            while (!pq.isEmpty()&&pq.peek().ind<i-k){
                pq.poll();// outside the range [i-k, i-1]
            }
            dp[i]=nums[i]+(pq.isEmpty()?0:pq.peek().val);

            pq.add(new Pair(Math.max(dp[i], 0), i));

            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}