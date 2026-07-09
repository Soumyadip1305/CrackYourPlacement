class Solution:
    def twoSum(self, nums: List[int], tar: int) -> List[int]:
        i=0
        j=len(nums)-1
        while i<j:
            sum=nums[i]+nums[j]
            if sum==tar:
                return list([i+1,j+1])
            elif sum>tar:
                j-=1
            else:
                i+=1
