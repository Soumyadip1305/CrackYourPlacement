class Solution {
    public int minGroups(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        
        for (int[] it : intervals) {
            list.add(new int[]{it[0], 1});
            list.add(new int[]{it[1] + 1, -1});
        }
        
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int sum = 0, maxi = 0;
        
        for (int[] it : list) {
            sum += it[1];
            maxi = Math.max(maxi, sum);
        }
        
        return maxi;
    }
}