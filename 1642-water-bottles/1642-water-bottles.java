class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int cnt = numBottles;
        int empty = numBottles;
        int fill = 0;
        while (empty >= numExchange) {
            fill = empty / numExchange;
            empty %= numExchange;
            empty+=fill;
            cnt += fill;
        }
        return cnt;
    }
}