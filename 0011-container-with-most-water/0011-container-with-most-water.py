from typing import List

class Solution:
    def maxArea(self, nums: List[int]) -> int:
        maxi = 0  
        l = 0
        r = len(nums) - 1

        while l < r:
            h_l = nums[l]
            h_r = nums[r]
            width = r - l
            
            if h_l < h_r:
                area = width * h_l
                l += 1
            else:
                area = width * h_r
                r -= 1
                
            if area > maxi:
                maxi = area
                
        return maxi

