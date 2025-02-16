class Solution {
    public int[] constructDistancedSequence(int n) {
         int[] res = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        solve(res, used, n, 0);
        return res;
    }

    private boolean solve(int[] res, boolean[] used, int n, int ind) {
        if (ind == res.length) {
            return true;
        }

        if (res[ind] != 0) {
            return solve(res, used, n, ind + 1); // Skip if already filled
        }
        for (int num = n; num >= 1; num--) {
            if (!used[num]) {
                if (num == 1) {
                    res[ind] = num;
                    used[num] = true;
                } else {
                    int nextIndex = ind + num; // The position for the second occurrence
                    if (nextIndex < res.length && res[nextIndex] == 0) {
                        res[ind] = num;
                        res[nextIndex] = num;
                        used[num] = true;
                    } else {
                        continue;
                    }
                }

                if (solve(res, used, n, ind + 1)) {
                    return true;
                }

                // Backtrack
                res[ind] = 0;
                if (num != 1) {
                    int nextIndex = ind + num;
                    res[nextIndex] = 0;
                }
                used[num] = false;
            }
        }

        return false;
    }
}