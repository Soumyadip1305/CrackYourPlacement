class Solution {
    public int maxDifference(String s) {
       // Map<Character,Integer>map=new HashMap<>();
        int[]ch=new int[26];
        for(char it:s.toCharArray()){
            ch[it-'a']++;
          //  map.put(it,map.getOrDefault(it,0)+1);
        }
       // System.out.println(Arrays.toString(ch));
        int maxOdd=0;
        int minEven=s.length();
        for(int it:ch){
            if(it%2==0&&it>0){
               minEven=Math.min(minEven,it);
            }else{
                maxOdd=Math.max(maxOdd,it); 
            }
        }
        return maxOdd-minEven;
    }
}