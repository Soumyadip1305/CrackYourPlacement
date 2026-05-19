class Solution {
    public int maxArea(int[] height) {
        int maxi=0;
        int l=0,r=height.length-1;

        while(l<r){
            maxi=Math.max(maxi,Math.min(height[r],height[l])*(r-l));
            if(height[l]<height[r]){
                l++;
            }else if(height[r]<height[l]){
                r--;
            }else{
                l++;
                r--;
            }
        }
        return maxi;
    }
}