class Solution {
    public boolean maxSubstringLength(String s, int k) {
        if (k == 0) return true;
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (first[ch - 'a'] == -1) {
                first[ch - 'a'] = i;
            }

            last[ch - 'a'] = i;
        }
//        System.out.println(Arrays.toString(first));
//        System.out.println(Arrays.toString(last));
        List<List<Integer>> specialSubStr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (first[s.charAt(i) - 'a'] != i) continue;
            int lastInd = last[s.charAt(i) - 'a'];
            boolean isValid = true;
            for (int ind = i; ind <= lastInd; ind++) {
                lastInd = Math.max(lastInd, last[s.charAt(ind) - 'a']);
                if (first[s.charAt(ind) - 'a'] < i) {
                    isValid = false;
                    break;
                }
            }

            if (isValid && !(i == 0 && lastInd == s.length() - 1)) {
                specialSubStr.add(Arrays.asList(i, lastInd));
            }
        }
        specialSubStr.sort(Comparator.comparingInt(a -> a.get(1)));
        System.out.println(specialSubStr);
        int prev = -1,cnt = 0;

        for(List<Integer> cur : specialSubStr){
            if(cur.get(0) > prev){
                cnt ++;
                prev = cur.get(1);
            }
        }
        //System.out.println(cnt);

        return cnt >= k;
    }
}