class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        for(int it:nums){
            map.put(it,map.getOrDefault(it,0)+1);
        }
      if (!map.containsKey(nums.length - 1) || map.get(nums.length - 1) != 2) {
    return false;
}

        for(int i = 1; i <= n - 2; i++){
            if(!map.containsKey(i) || map.get(i) != 1){
                return false;
            }
        }
        return true;
    }
}