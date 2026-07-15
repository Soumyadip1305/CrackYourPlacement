class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n=len(nums)
        diff=nums[n-2]+nums[n-1]+nums[n-3]

        for i in range(n-2):
            l=i+1
            r=n-1

            while(l<r):
                curr_sum=nums[i]+nums[l]+nums[r]
                if curr_sum>target:
                    r-=1
                elif curr_sum<target:
                    l+=1
                else:
                    return target
                if abs(curr_sum - target) < abs(diff - target):diff = curr_sum
        return diff