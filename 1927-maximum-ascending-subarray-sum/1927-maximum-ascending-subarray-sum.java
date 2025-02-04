class Solution {
    public int maxAscendingSum(int[] nums) {
       int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                //   System.out.println(sum);
                if (curr < nums[j]) {
                    curr = nums[j];
                    sum += nums[j];

                } else {
                    break;
                }
            }
            maxi = Math.max(sum, maxi);
        }
        return maxi;
        }
}