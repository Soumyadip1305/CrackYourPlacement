class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int currMin = arrays.get(0).get(0);
        int currMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < arrays.size(); i++) {
            int min = arrays.get(i).get(0);
            int max = arrays.get(i).get(arrays.get(i).size() - 1);

            ans = Math.max(ans, Math.max(Math.abs(currMax - min), Math.abs(max - currMin)));

            currMin = Math.min(currMin, min);
            currMax = Math.max(currMax, max);
        }

        return ans;
    }
}