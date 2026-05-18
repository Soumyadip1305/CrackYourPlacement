class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i=0;i<numbers.length;i++){
            int ind=searchInd(numbers,i+1,target-numbers[i]);
            if (ind!=-1){
                return new int[]{i+1,ind+1};
            }
        }
        return new int[]{-1,-1};
    }


    static int searchInd(int[]nums,int l,int tar){
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == tar) {
                return mid;
            } else if (nums[mid] < tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}