class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int req = need.size(), formed = 0;
        int i = 0;
        Map<Character, Integer> curr = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            curr.put(s.charAt(j), curr.getOrDefault(s.charAt(j), 0) + 1);
            if (need.containsKey(s.charAt(j)) && Objects.equals(curr.get(s.charAt(j)), need.get(s.charAt(j)))) {
                formed++;
            }

            while (formed == req) {
                if ((j - i + 1) < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }
                /*
                Try shrinking from left
                Update minimum length
                Carefully decrease formed when breaking condition
                 */
                curr.put(s.charAt(i), curr.get(s.charAt(i)) - 1);  // remove left char

                if (need.containsKey(s.charAt(i)) && curr.get(s.charAt(i)) < need.get(s.charAt(i))) {
                    formed--;
                }
                i++;
            }
        }
        if (minLen == Integer.MAX_VALUE)
            return "";
        else
            return s.substring(start, start + minLen);
    }
}