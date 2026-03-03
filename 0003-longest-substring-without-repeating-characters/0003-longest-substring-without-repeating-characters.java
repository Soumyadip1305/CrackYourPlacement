class Solution {
    public int lengthOfLongestSubstring(String s) {
        

        int maxi=0;
        Map<Character,Integer>map=new HashMap<>();
        int i=0;
        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>1){
                char c=s.charAt(i);
                map.put(c,map.get(c)-1);
                i++;
            }
            maxi=Math.max(maxi,j-i+1);
        }
        return maxi;
    }
}