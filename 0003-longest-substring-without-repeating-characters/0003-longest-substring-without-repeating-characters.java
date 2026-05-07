class Solution {
    public int lengthOfLongestSubstring(String s) {
       Map<Character,Integer>map=new HashMap<>();
        int maxi=0;

        int i=0;
        for (int j = 0; j < s.length(); j++) {
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);


            while (map.get(s.charAt(j))>1){
                char l=s.charAt(i);

                map.put(l,map.get(l)-1);
                if (map.get(l)==0)map.remove(l);
                i++;
            }
            maxi=Math.max(j-i+1,maxi);
        }
        return maxi;
    }
}