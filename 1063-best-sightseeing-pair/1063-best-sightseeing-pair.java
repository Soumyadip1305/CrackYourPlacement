class Solution {
    public int maxScoreSightseeingPair(int[] values) {
         int maxi = 0;
        int maxI=values[0];
        int n = values.length;

        for (int j = 1; j < n ; j++) {
             maxi= Math.max(maxi,maxI+ values[j] - j);
            maxI = Math.max(values[j]+j, maxI);
        }
        return maxi;
    }
}
