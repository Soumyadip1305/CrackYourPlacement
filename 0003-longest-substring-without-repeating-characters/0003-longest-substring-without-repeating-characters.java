class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,maxi=0;
        Map<Character,Integer>isPres=new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            isPres.put(s.charAt(j), isPres.getOrDefault(s.charAt(j), 0) + 1);
            while (isPres.get(s.charAt(j))>1){
                isPres.put(s.charAt(i), isPres.get(s.charAt(i)) -1);
                i++;
            }
            maxi=Math.max(maxi,j-i+1);
        }
        return maxi;
    }
}