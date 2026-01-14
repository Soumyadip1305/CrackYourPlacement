class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length(), i = 0, j = 0, maxi = 0;


        char[] freq = new char[128];
        while (i < n && j < n) {

            char ch = s.charAt(j);
            if (freq[ch] == 0) {
                freq[ch]++;
                maxi = Math.max(j - i + 1, maxi);
                j++;
            } else {
                freq[s.charAt(i)]--;
                i++;
            }

        }
        return maxi;
    }
}