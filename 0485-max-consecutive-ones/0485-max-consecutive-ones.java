class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi=0;
        int prev=nums[0];
        int cnt=0;
        if(prev==1)cnt=1;
        for(int i=1;i<nums.length;i++){
            
            if(prev==1&&prev==nums[i]){
                cnt++;
            }else if(prev==0&&nums[i]==1){
                cnt=1;
                prev=1;
            }
             maxi=Math.max(cnt,maxi);
            if(nums[i]==0){
                cnt=0;
                prev=0;
            }
           // System.out.println(maxi);
        }
                    maxi=Math.max(cnt,maxi);

        return maxi;
    }
}