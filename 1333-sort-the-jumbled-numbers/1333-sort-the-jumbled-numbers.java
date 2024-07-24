class Solution {
    private class Pair {
        int original;
        int mapped;

        Pair(int original, int mapped) {
            this.original = original;
            this.mapped = mapped;
        }
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // List<Pair> pairs = new ArrayList<>();
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
            // pairs.add(new Pair(num, calculateMap(mapping, num)));
        }

       // pairs.sort(Comparator.comparingInt(p -> p.mapped));
        Arrays.sort(indices, Comparator.comparingInt(i -> calculateMap(mapping, nums[i])));

        int[] ans = new int[nums.length];
        for (int i = 0; i < indices.length; i++) {
            ans[i] = nums[indices[i]];
        }

        return ans;
    }

    private static int calculateMap(int[] mapping, int num) {
        if (num == 0) {
            return mapping[0];
        }

        int ans = 0;
        int fact = 1;
        while (num > 0) {
            int digit = num % 10;
            ans = mapping[digit] * fact + ans;
            fact *= 10;
            num /= 10;
        }

        return ans;
    }
}