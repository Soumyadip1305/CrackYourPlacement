class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        List<Integer> arr = fill(nums);
        int cnt = 0;

        while (!isNonDecreasing(arr)) {
            int mini = Integer.MAX_VALUE;
            int ind = -1;

            for (int i = 0; i < arr.size() - 1; i++) {
                int sum = arr.get(i) + arr.get(i + 1);
                if (sum < mini) {
                    mini = sum;
                    ind = i;
                }
            }
            arr.set(ind, arr.get(ind) + arr.get(ind + 1));
            arr.remove(ind + 1);
            cnt++;
        }

        return cnt;
    }
    private static List<Integer> fill(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        return list;
    }

    private static boolean isNonDecreasing(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1)) return false;
        }
        return true;
    }
}