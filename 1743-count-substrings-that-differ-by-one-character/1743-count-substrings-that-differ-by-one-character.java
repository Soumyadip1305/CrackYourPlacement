class Solution {
    public int countSubstrings(String s, String t) {
      int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int miss = 0;
                for (int k = 0; i + k < s.length() && j + k < t.length(); k++) {
                    if (s.charAt(i + k) != t.charAt(j + k)) {
                        miss++;
                    }

                    if (miss == 1) {
                        cnt++;
                    } else if (miss > 1) {
                        break;
                    }
                }
            }
        }

        return cnt; 
    }
}