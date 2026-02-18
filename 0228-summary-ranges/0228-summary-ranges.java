class Solution {
    public List<String> summaryRanges(int[] nums) {
          List<String> ans = new ArrayList<>();
          int n=nums.length;
        if (n == 0) return ans;

        int prev = nums[0];

        for (int i = 1; i <= n; i++) {

            if (i == n || nums[i] != nums[i - 1] + 1) {

                if (prev == nums[i - 1]) {
                    ans.add(prev + "");
                } else {
                    ans.add(prev + "->" + nums[i - 1]);
                }

                if (i < nums.length)
                    prev = nums[i];
            }
        }

        return ans;
    }
}