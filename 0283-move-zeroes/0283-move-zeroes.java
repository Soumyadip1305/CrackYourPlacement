class Solution {
    public void moveZeroes(int[] nums) {
        int s=0;
        for(int f=0;f<nums.length;f++){
            
            if(nums[f]!=0){
                if(s != f){
                    nums[s] = nums[f];
                    nums[f] = 0;
                }
                s++;
            }
        }
    }
}