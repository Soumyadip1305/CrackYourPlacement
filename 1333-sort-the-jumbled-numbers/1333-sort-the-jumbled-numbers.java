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
        List<Pair> pairs = new ArrayList<>();
        for (int num : nums) {
            pairs.add(new Pair(num, calculateMap(mapping, num)));
        }

        pairs.sort(Comparator.comparingInt(p -> p.mapped));

        int[] ans = new int[nums.length];
        for (int i = 0; i < pairs.size(); i++) {
            ans[i] = pairs.get(i).original;
        }

        return ans;
    }

    private int calculateMap(int[] mapping, int num) {
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