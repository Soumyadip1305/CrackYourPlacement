class Solution {
    public long fact(int x) {
        long res = 1;
        for (int i = 1; i <= x; i++) res *= i;
        return res;
    }

    public void gen(char[] num, int i, List<String> list, int k) {
        if (i >= (num.length + 1) / 2) {
            String s = new String(num);
            if (Long.parseLong(s) % k == 0) list.add(s);
            return;
        }

        if (i != 0) {
            num[i] = '0';
            num[num.length - 1 - i] = '0';
            gen(num, i + 1, list, k);
        }

        for (char c = '1'; c <= '9'; c++) {
            num[i] = c;
            num[num.length - 1 - i] = c;
            gen(num, i + 1, list, k);
        }
    }

    public long countGoodIntegers(int n, int k) {
        List<String> list = new ArrayList<>();
        char[] num = new char[n];
        Arrays.fill(num, '0');
        gen(num, 0, list, k);

        Set<String> set = new HashSet<>();

        for (String s : list) {
            int[] freq = new int[10];
            for (char c : s.toCharArray()) freq[c - '0']++;

            StringBuilder sb = new StringBuilder();
            for (int f : freq) sb.append((char) ('a' + f));
            set.add(sb.toString());
        }

        long total = fact(n), ans = 0;

        for (String p : set) {
            long cnt = total;
            for (char c : p.toCharArray()) cnt /= fact(c - 'a');

            if (p.charAt(0) != 'a') {
                int z = p.charAt(0) - 'a' - 1;
                long bad = fact(n - 1);
                for (int j = 1; j < p.length(); j++) bad /= fact(p.charAt(j) - 'a');
                bad /= fact(z);
                cnt -= bad;
            }

            ans += cnt;
        }

        return ans;
    }
}