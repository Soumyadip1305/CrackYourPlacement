class Solution {
    public int maxScore(int[] cardPoints, int k) {
      int n = cardPoints.length;
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += cardPoints[i];
        }
        int maxi = curr;

        for (int i = 0; i < k; i++) {
            curr -= cardPoints[k - 1 - i];
            curr += cardPoints[n - 1 - i];
            maxi = Math.max(maxi, curr);
        }

        return maxi;  
    }
}