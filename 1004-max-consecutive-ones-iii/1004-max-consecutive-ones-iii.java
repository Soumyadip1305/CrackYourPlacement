class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, cntZ = 0, ans = 0;

        for (int j = 0; j < nums.length; j++) {
           if (nums[j]==0){
               cntZ++;
           }

            while (cntZ > k) {
                if (nums[i]==0){
                    cntZ--;
                }
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}