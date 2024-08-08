class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<2)return s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int maxi=0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxi= Math.max(maxi,set.size());
            }else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxi;
    }
}