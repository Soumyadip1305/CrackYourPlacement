class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        s=0
        for f in range(0,len(nums)):
            if nums[f]!=0:
                nums[s],nums[f]=nums[f],nums[s]
                s+=1
        return nums
        