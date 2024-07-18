class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int currMin=Integer.MAX_VALUE;
        for (int it : prices) {
            if (it < currMin) {
                currMin = it;
            } else if (currMin < it) {
                ans += it - currMin;
                currMin = it;
            }
        }
        return ans;
    }
}