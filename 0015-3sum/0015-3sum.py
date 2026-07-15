class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        ans=[]
        nums.sort()
        for i in range(0,len(nums)-2):
            #check for duplicate 
            if i>0 and nums[i]==nums[i-1]:
                continue
            l=i+1
            r=len(nums)-1
            while(l<r):
                curr_sum=nums[i]+nums[l]+nums[r]
                if curr_sum==0:
                    ans.append([nums[i],nums[l],nums[r]])
                    while l<r and nums[l]==nums[l+1]:l+=1
                    while l<r and nums[r]==nums[r-1]:r-=1
                    l+=1
                    r-=1
                elif curr_sum<0:
                    l+=1
                else:
                    r-=1
        return ans
    