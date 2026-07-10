class Solution:
    def trap(self, nums: List[int]) -> int:
        l=0
        r=len(nums)-1
        lm=rm=0
        ans=0

        while l<r:
            if nums[l]<=nums[r]:   # here I no sence to go or increase rm because it's alrerady bigger 
                if lm<=nums[l]:
                    lm=nums[l]
                else:
                    ans+=(lm-nums[l])
                l+=1
            # check if 1st cond fails
            else:  # just copy and change parameter 
                if rm<=nums[r]:
                    rm=nums[r]
                else:
                    ans+=(rm-nums[r])
                # l-=1
                r-=1
        return ans

# Time Limit Exceeded
# Last Executed Input
# Open Testcase
# height =
# [0,1,0,2,1,0,1,3,2,1,2,1]   Why ? 

#  see :