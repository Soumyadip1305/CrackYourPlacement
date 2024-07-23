class Solution {
    public boolean canJump(int[] arr) {
        int r = 0;
        for (int l = 0; l < arr.length; l++) {
            if (l > r) return false;
            r = Math.max(r, l + arr[l]);
        }
        return true;
    }
}