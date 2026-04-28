class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : grid) {
            for (int it : row) {
                list.add(it);
            }
        }
        Collections.sort(list);
        int target = list.get(list.size() / 2);

        int cnt = 0;
        for (int value : list) {
            int diff = Math.abs(value - target);
            if (diff % x != 0) {
                return -1;
            }
            cnt += diff / x;
        }

        return cnt;
    }
}