class Solution {
    public int findChampion(int n, int[][] edges) {
         int[] arr = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] i : edges) {
            arr[i[1]]++;
            list.get(i[0]).add(i[1]);
        }
        int res = -1;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                if (cnt > 0) {
                    return -1;
                }
                res = i;
                cnt++;
            }
        }
        return res;
    }
}