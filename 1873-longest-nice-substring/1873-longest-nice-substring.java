class Solution {
    public String longestNiceSubstring(String s) {
        String maxi = "";
        int n=s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String curr = s.substring(i, j + 1);
                if (isNice(curr)) {
                    if (curr.length() > maxi.length()) {
                        maxi = curr;
                    }
                }
            }
        }

        return maxi;
    }

    private static boolean isNice(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        for (char ch : set) {
            if (Character.isLowerCase(ch) && !set.contains(Character.toUpperCase(ch))||Character.isUpperCase(ch) && !set.contains(Character.toLowerCase(ch))) {
                return false;
            }
        }
        return true;
    }
}