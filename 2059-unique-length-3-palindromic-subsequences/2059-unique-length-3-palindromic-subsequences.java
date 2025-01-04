class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] firstOcc = new int[26];
        int[] lastOcc = new int[26];

        Arrays.fill(firstOcc, -1);
        Arrays.fill(lastOcc, -1);

        for (int i = 0; i < s.length(); i++) {
            if (firstOcc[s.charAt(i) - 'a'] == -1) {
                firstOcc[s.charAt(i) - 'a'] = i;
            }
            lastOcc[s.charAt(i) - 'a'] = i;
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            if (firstOcc[i] != -1 && firstOcc[i] < lastOcc[i]) {
                boolean[] seen = new boolean[26];
                for (int j = firstOcc[i] + 1; j < lastOcc[i]; j++) {
                    if (!seen[s.charAt(j) - 'a']) {
                        set.add((char) ('a' + i) + "" + s.charAt(j) + (char) ('a' + i));
                        seen[s.charAt(j) - 'a'] = true;
                    }
                }
            }
        }

        return set.size();
    }
}