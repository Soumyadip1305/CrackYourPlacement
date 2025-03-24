class Solution {
    public int numTimesAllBlue(int[] flips) {
        int cnt = 0;
        int maxFlipped = 0, onCount = 0;

        for (int flip : flips) {
            maxFlipped = Math.max(maxFlipped, flip);
            onCount++;

            if (maxFlipped == onCount) {
                cnt++;
            }
        }
        return cnt;
    }
}