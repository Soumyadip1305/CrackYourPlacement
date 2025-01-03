class Solution {
    public int minMoves(int[] nums) {
        int cnt=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            cnt+=(nums[i]-nums[0]);
        }
        return cnt;
    }
}
/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

  for 4 len array I can increase maximum 3 element

  1 2 3    2 1
  2 3 3
  3 4 3
  4 4 4


  1 2 3 

  3-1  2-1   2+1


  1 1 1 
*/