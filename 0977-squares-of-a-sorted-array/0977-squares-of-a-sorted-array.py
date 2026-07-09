class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        i=0
        j=p=len(nums)-1
        ans=[0]*len(nums)
        
        while i<=j:
            if abs(nums[i])<abs(nums[j]):
                ans[p]=nums[j]**2
                j-=1
            elif abs(nums[i])>abs(nums[j]):
                ans[p]=nums[i]**2
                i+=1
            else:
                ans[p]=nums[i]**2
                i+=1
            p-=1
        return ans
        