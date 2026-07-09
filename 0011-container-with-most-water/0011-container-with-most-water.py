class Solution:
    def maxArea(self, nums: List[int]) -> int:
        maxi=-float('inf')
        l=0
        r=len(nums)-1

        while(l<r):
            maxi=max(maxi,(r-l)*min(nums[l],nums[r]))

            if nums[l]<nums[r]:
                l+=1
            else:
                r-=1
        return maxi