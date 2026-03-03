class Solution {
    public int countCompleteSubarrays(int[] nums) {
        /*
        Always cnt=1 because the array itself is an ans

        */
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int need=set.size();
        Map<Integer,Integer>map=new HashMap<>();
        int i=0;
        int cnt=0;

        for(int j=0;j<nums.length;j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);


            while(map.size()==need){
                cnt += nums.length - j;

            map.put(nums[i], map.get(nums[i]) - 1);
            if (map.get(nums[i]) == 0) {
                map.remove(nums[i]);
            }
            i++;
        }
    }

    return cnt;
    }
}