from typing import List

class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n = len(nums)

        diff = nums[0] + nums[1] + nums[2]

        for i in range(n - 2):
            l = i + 1
            r = n - 1

            while l < r:
                curr_sum = nums[i] + nums[l] + nums[r]

                if abs(curr_sum - target) < abs(diff - target):
                    diff = curr_sum

                if curr_sum > target:
                    r -= 1
                elif curr_sum < target:
                    l += 1
                else:
                    return target

        return diff