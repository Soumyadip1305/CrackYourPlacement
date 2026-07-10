class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        s=f=0
        while f<len(nums):
            if nums[f]==nums[s]:
                f+=1
            else:
                s+=1
                nums[s]=nums[f]
        return s+1 # unique element 