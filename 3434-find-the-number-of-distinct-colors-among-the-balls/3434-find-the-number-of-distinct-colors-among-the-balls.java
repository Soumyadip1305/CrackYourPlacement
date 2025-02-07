class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> bc = new HashMap<>();
        Map<Integer, Integer> cf = new HashMap<>();
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int newColor = queries[i][1];

            updateColor(bc, cf, ball, newColor);
            result[i] = cf.size();
        }

        return result;
    }

   private static void updateColor(Map<Integer, Integer> map, Map<Integer, Integer> cf, int ball, int nc) {
        int oc = map.getOrDefault(ball, -1);

        if (oc != nc) {
            map.put(ball, nc);
            if (oc != -1) {
                cf.put(oc, cf.get(oc) - 1);
                if (cf.get(oc) == 0) {
                    cf.remove(oc);
                }
            }
            cf.put(nc, cf.getOrDefault(nc, 0) + 1);
        }
    }
}