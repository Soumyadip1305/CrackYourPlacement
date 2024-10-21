class Solution {
    public long countBadPairs(int[] nums) {
    
    Map<Integer,Integer>map=new HashMap<>();
    long ans=0;
    map.put(0-nums[0],1);
    for(int i=1;i<nums.length;i++){

        if(map.containsKey(i-nums[i])){
            ans+=i-map.get((i-nums[i]));
        }else{
            ans+=i;
        }
         map.put(i-nums[i], map.getOrDefault(i-nums[i], 0) + 1);
    }
    return ans;
    }
}