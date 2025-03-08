class Solution {
    public int minimumRecolors(String blocks, int k) {
        int mini = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int n = blocks.length();
        int b = 0;
        while (j < n) {
            if (blocks.charAt(j) == 'B'){
                b++;
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                mini = Math.min(mini, k - b);
                if (blocks.charAt(i) == 'B'){
                    b--;
                }
                i++;
                j++;
            }
        }
        return mini;
    }
}