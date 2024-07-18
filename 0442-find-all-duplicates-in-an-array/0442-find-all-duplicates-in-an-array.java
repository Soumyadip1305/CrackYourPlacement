class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    /* List<Integer>ans=new ArrayList<>();
     HashMap<Integer,Integer>map=new HashMap<>();
     for(int x:nums){
        map.put(x,map.getOrDefault(x,0)+1);
     }   
     List<Integer>ans=new ArrayList<>();
     for(Map.Entry<Integer,Integer>entry:map.entrySet()){
        if(entry.getValue()>1)ans.add(entry.getKey());
     }
     return ans;
     */

     List<Integer>ans=new ArrayList<>();
     for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]) - 1;
            if (nums[ind] < 0) {
                ans.add(Math.abs(nums[i]));
            } else {
                nums[ind] = -nums[ind];
            }
        }
        return ans;
    }
}