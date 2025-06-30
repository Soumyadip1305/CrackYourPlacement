class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();

        for(int it:nums)map.put(it,map.getOrDefault(it,0)+1);
        int maxi=0;
        for(int it:nums){

            if(map.containsKey(it)){
                if(map.containsKey(it+1)){
                    maxi=Math.max(maxi,map.get(it+1)+map.get(it));
                }
            }
        }
        return maxi;
    }
}

//1 2 2 2 3 3 5 7 