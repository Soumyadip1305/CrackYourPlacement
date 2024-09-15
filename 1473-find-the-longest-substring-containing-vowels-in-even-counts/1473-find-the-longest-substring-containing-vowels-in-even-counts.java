
class Solution {
    public int findTheLongestSubstring(String s) {

        HashMap<Integer, Integer> mp = new HashMap<>();
        
        mp.put(0, -1);

        int cur = 0, n = s.length(), len = 0;

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (isVowel(ch)) {

                int ind = ch - 'a';

                cur = cur ^ (1 << ind);
            }

            if (mp.containsKey(cur)) {
                int prevInd = mp.get(cur);
                len = Math.max(len, i - prevInd);
            } 
            else{
                mp.put(cur, i);
            }

        }

        return len;

    }

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

/*
 * 1.longest subString contains vowel even no of times
 * 
 */