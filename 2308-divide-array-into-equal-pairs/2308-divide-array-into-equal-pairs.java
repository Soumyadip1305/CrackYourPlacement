class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for (int it:nums){
            map.put(it,map.getOrDefault(it,0)+1);
        }
        for (int it:map.values()){
            if (it%2!=0){
                return false;
            }
        }
        return true;
    }
}