class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        Map<Integer,Integer>map=new HashMap<>();
        for (int it:nums) {
            map.put(it,map.getOrDefault(it,0)+1);
        }
        for (int it : nums) {
            int val = map.get(it);
            if (val == 1 && !map.containsKey(it - 1) && !map.containsKey(it + 1)) {
                ans.add(it);
            }
        }
        return ans;
    }
}