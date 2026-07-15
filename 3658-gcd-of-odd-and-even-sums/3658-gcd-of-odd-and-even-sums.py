class Solution:
    def gcdOfOddEvenSums(self, n: int) -> int:
        return gcd(n**2,n**2+n)
    def gcd(a,b):
        if b==0:return a
        return gcd(b,a%b)