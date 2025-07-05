class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int it:arr){
            map.put(it,map.getOrDefault(it,0)+1);
        }
        int maxi=-1;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getKey()==entry.getValue()){
                maxi=Math.max(entry.getValue(),maxi);
            }
        }
        return maxi;
    }
}