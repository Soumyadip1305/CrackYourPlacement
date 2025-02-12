class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int maxSum = -1; 
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int digitSum = sumOfDigit(nums[i]);

            if (map.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, nums[i] + map.get(digitSum));
            }

            map.put(digitSum, Math.max(map.getOrDefault(digitSum, 0), nums[i]));
        }

        return maxSum;
    }
     /*
    18,43,36,13,7

    7 13 18 36 43
    7 4 9 9 7

     */
    static int sumOfDigit(int n){

        int sum=0;

        while (n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}