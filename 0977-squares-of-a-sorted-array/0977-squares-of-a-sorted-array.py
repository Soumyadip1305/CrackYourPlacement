class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        i = 0
        j = len(nums) - 1
        p = len(nums) - 1

        ans = [0] * len(nums)

        while i <= j:
            if abs(nums[i]) > abs(nums[j]):
                ans[p] = nums[i] * nums[i]
                i += 1
            else:
                ans[p] = nums[j] * nums[j]
                j -= 1

            p -= 1

        return ans