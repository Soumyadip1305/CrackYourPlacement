class Solution {
    public int maxProfit(int[] prices) {
        int curr=prices[0];
        int maxi=0;

        for(int i=1;i<prices.length;i++){
            if(curr>=prices[i]){
                curr=prices[i];
            }else{
                maxi=Math.max(prices[i]-curr,maxi);
            }
        }
        return maxi;
    }
}