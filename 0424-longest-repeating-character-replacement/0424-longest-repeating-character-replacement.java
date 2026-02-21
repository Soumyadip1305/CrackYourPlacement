class Solution {
    public int characterReplacement(String s, int k) {
       int[] arr = new int[26];
        int i = 0, maxFre = 0, maxi = 0;

        for (int j = 0; j < s.length(); j++) {

            int ch=s.charAt(j)-'A';
            arr[ch]++;
            maxFre = Math.max(maxFre, arr[ch]);

            while ((j - i + 1) - maxFre > k) {
                arr[s.charAt(i)-'A']--;
                i++;
            }

            maxi = Math.max(maxi, j - i + 1);
        }

        return maxi;
    }
}