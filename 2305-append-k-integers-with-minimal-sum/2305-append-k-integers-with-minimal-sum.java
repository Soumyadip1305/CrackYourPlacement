class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0, next = 1;

        for (int it : nums) {
            while (next < it && k > 0) {
                sum += next;
                next++;
                k--;
            }
            if (it == next) next++;
        }

        while (k > 0) {
            sum += next;
            next++;
            k--;
        }

        return sum;
    }
}