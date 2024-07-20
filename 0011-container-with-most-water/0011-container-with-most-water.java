class Solution {
    public int maxArea(int[] height) {
        int maxi=0;
        int low=0,high=height.length-1;
        while (low<high){
            int mini=Math.min(height[low],height[high]);
            maxi=Math.max(maxi,mini*(high-low));
            if (height[low]<height[high]){
                low++;
            } else if (height[low]>height[high]) {
                high--;
            }else {
                low++;
                high--;
            }
        }
        return maxi;
    }
}