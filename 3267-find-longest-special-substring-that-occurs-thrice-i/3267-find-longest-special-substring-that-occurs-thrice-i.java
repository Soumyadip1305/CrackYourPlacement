class Solution {
    public int maximumLength(String s) {
            int n = s.length();

        Map<String, Integer> map = new HashMap<>();

        int maxi = 0, ans = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);

                int cnt = 0;
                if (sub.length() > 1) {
                    char ch = sub.charAt(0);

                    for (int k = 1; k < sub.length(); k++) {
                        if (ch != sub.charAt(k)) {
                            cnt = 1;
                            break;
                        }
                    }
                }

                if (cnt == 0) {
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                    maxi = Math.max(maxi, sub.length());
                }
            }
        }

        if (maxi >= 3) {
            ans = Math.max(ans, maxi - 2);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3 && entry.getKey().length() > ans) {
                ans = entry.getKey().length();
            }
        }

        return ans;
    }
}