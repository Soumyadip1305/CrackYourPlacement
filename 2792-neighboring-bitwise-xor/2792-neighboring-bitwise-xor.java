class Solution {
    public boolean doesValidArrayExist(int[] derived) {
      int ans = 0;

        for(int it : derived){
             ans ^= it;
        }

        return ans == 0;   
    }
}