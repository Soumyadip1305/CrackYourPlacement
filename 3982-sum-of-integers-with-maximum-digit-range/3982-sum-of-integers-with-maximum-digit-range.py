class Solution:
    def maxDigitRange(self, nums: list[int]) -> int:
        dic={}
        for it in nums:
            mx = int(max(str(it)))
            mn = int(min(str(it)))
            diff=mx-mn
            #print(mx,' ',mn) 
            if diff in dic:
                dic[diff]=dic[diff]+it
            else:
                dic[diff]=it
        return dic[max(dic.keys())]