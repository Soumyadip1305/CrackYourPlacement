class Solution {
    public int[] rearrangeArray(int[] nums) {
         int[] ans = new int[nums.length];
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int num : nums) {
            if (num < 0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

       int k = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            ans[k++] = pos.get(i);
            ans[k++] = neg.get(i);
        }
        return ans;
    }
}