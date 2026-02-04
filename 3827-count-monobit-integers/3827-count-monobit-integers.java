class Solution {
    public int countMonobit(int n) {
         return 1 + (int)(Math.log(n + 1) / Math.log(2));
    }
}