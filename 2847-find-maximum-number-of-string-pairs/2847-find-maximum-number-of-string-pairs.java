class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int cnt = 0;
        HashSet<String> set = new HashSet<>();
        for (String it : words) {
            String reversed = it.charAt(1) + "" + it.charAt(0);
            if (set.contains(reversed)) {
                cnt++;
            } else {
                set.add(it);
            }
        }
        return cnt;
    }
}