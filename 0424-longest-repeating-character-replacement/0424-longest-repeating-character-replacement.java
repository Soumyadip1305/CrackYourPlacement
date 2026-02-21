class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, maxFre = 0, maxi = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            char ch=s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFre = Math.max(map.get(ch), maxFre);

            while ((j - i + 1) - maxFre > k) {
                // means it's having mre than k difference need remove ith
                char lch = s.charAt(i);
               // if (map.get(lch) == maxFre) maxFre--;
                map.put(lch, map.get(lch) - 1);
                i++;
            }
            maxi=Math.max(maxi,j-i+1);
        }
        return maxi;
    }
    /*
one problem occurs that when I remove B there max freq=B=A, so in this case it remove A also
    s =
"BAAA"
k =
0

Use Testcase
Output
2
Expected
3
*/
}