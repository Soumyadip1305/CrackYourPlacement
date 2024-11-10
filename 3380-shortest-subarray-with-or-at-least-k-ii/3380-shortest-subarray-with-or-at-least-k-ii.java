class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        if(k == 0) return 1;
        int[]bit = new int[31];
        int l = 0,  n = nums.length, resLen = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++ ){
            int cur = nums[i];

            for(int j = 0; j < 31; j++){
                if((cur & ( 1 << j)) != 0){
                    bit[j]++;
                }
            }
            while(l < n && calculateValue(bit) >= k){

                resLen = Math.min(resLen, i - l + 1);

                 cur = nums[l];

                for(int j = 0; j < 31; j++){
                    if((cur & ( 1 << j)) != 0){
                    bit[j]--;
                }
                }

                l++;
            }

        }
        return resLen == Integer.MAX_VALUE ? -1 : resLen;
    }
    int calculateValue(int[]bit){
        int val = 0;
        int curPow = 1;
        for(int i = 0; i < 31; i++){
            if(i > 0)curPow *=2;

            if(bit[i] > 0){
                val += curPow;
            }  
        }
        return val;
    } 
}