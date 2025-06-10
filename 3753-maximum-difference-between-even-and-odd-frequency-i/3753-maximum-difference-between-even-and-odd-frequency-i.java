class Solution {
    public int maxDifference(String s) {
        Map<Character,Integer>map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int maxOdd=Integer.MIN_VALUE;
        int minEven=Integer.MAX_VALUE;
        for(int it:map.values()){
            if(it%2==0){
               minEven=Math.min(minEven,it);
            }else{
                maxOdd=Math.max(maxOdd,it); 
            }
        }
        return maxOdd-minEven;
    }
}