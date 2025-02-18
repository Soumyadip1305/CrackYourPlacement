class Solution {
    public int minOperations(int[] nums, int x) {
         int sum = 0, len = nums.length;
        for (Integer i : nums)sum += i;

        int k = sum - x;  
        if (k == 0) return len;

        // now the problem becomes find longest subarray whose sum = k

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0, maxLength = -1;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            currSum += curr;

            if (map.containsKey(currSum - k))
                maxLength = Math.max(maxLength, i - map.get(currSum - k));

            if (!map.containsKey(currSum)) {
                map.put(currSum, i); 
            }
        }

        return maxLength == -1 ? -1 : len - maxLength; 
    }
}