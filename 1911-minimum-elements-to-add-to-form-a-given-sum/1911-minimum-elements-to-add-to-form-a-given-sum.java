class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum=0;
        for (int it:nums)sum+=it;
        long diff = Math.abs(goal - sum);
        return (int) ((diff + limit - 1) / limit);
    }
}