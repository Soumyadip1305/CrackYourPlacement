class Solution {
    public String largestMerge(String word1, String word2) {
      // if char is same then take from the highest string
        int i = 0, j = 0, n = word1.length(), m = word2.length();
        StringBuilder ans = new StringBuilder();
        while (i < n && j < m) {
            if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                ans.append(word1.charAt(i));
                i++;
            } else {
                ans.append(word2.charAt(j));
                j++;
            }
        }
        while (i < n) {
            ans.append(word1.charAt(i));
            i++;
        }

        while (j < m) {
            ans.append(word2.charAt(j));
            j++;
        }
        return ans.toString();  
    }
}