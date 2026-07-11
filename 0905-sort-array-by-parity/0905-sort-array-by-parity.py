class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        s=0
        for f in range(0,len(nums)):
            if nums[f]%2==0:
                nums[s],nums[f]=nums[f],nums[s]
                s+=1
        return nums
        