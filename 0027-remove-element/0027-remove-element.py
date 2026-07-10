class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        f=s=0

        for f in range (0,len(nums)):
            if nums[f]!=val:
                nums[s]=nums[f]
                s+=1
            
        return s