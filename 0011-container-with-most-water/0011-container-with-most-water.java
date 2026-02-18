class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int maxi=-1;
        while(l<r){
            int curr=Math.min(height[l],height[r]);
            maxi=Math.max(maxi,curr*(r-l));

            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxi;
    }
}