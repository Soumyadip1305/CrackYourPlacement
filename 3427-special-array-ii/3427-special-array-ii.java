class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) { 
    ArrayList<Integer> adj = createAdjacencyList(nums);
        int n = queries.length;
        boolean[] dp = new boolean[n];
        int i = 0;
        for (int[] q : queries) {
            int x = q[0];
            int y = q[1];
            int dis1 = binary_search(adj, x);
            int dis2 = binary_search(adj, y);
            dp[i] = dis2 == -1 || dis1 >= dis2;
            i++;
        }
        return dp;
    }
    private ArrayList<Integer> createAdjacencyList(int[] nums) {
        ArrayList<Integer> adj = new ArrayList<>();
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if ((nums[i] % 2 == 0 && nums[i - 1] % 2 == 0) || (nums[i] % 2 != 0 && nums[i - 1] % 2 != 0)) {
                adj.add(i);
            }
        }
        return adj;
    }
    int binary_search(ArrayList<Integer> adj, int t) {
        int ans = -1;
        int l = 0, r = adj.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (adj.get(mid) <= t) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    } 
}