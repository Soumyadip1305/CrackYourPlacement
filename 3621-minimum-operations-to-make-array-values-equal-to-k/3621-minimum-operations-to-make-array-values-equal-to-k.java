class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            if (num <k) {
                return -1;
            }
        }

        return calculateAns(nums,k);
    }

    private int calculateAns(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : nums) {
            set.add(num);
        }

        int cnt = 0;
        while (!set.isEmpty()) {
            int max = set.pollFirst();
            if (max == k) continue;

            int next = Math.max(k, set.isEmpty() ? k : set.first());
            set.add(next);
            cnt++;
        }

        return cnt;
    }
}