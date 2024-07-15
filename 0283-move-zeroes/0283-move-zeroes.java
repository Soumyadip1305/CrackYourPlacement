class Solution {
    public void moveZeroes(int[] nums) {
        int k=0;
        int cnt=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[k++]=nums[i];
                cnt++;
            }
        }
        for (int i = cnt; i <nums.length ; i++) {
            nums[i]=0;
        }
    }
}