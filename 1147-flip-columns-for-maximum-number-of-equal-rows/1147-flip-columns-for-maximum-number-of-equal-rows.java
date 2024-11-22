class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();

        for (int[] it : matrix) {
            StringBuilder normal = new StringBuilder();
            StringBuilder flipped = new StringBuilder();

            for (int val : it) {
                normal.append(val);
                flipped.append(1 - val);
            }

            String need = normal.toString().compareTo(flipped.toString()) < 0 ? normal.toString() : flipped.toString();
            // System.out.println(need);
            map.put(need, map.getOrDefault(need, 0) + 1);
        }
        // System.out.println(map);
        int maxi = 0;
        for (int val : map.values()) {
            maxi=Math.max(maxi,val);
        }
        return maxi;
    }
}