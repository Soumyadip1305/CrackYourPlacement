class Solution:
    def isPalindrome(self, s: str) -> bool:
        t = "".join(char for char in s if char.isalnum()).lower()
        i=0
        j=len(t)-1
        while j>i:
            if t[j]!=t[i]:
                return False
            j-=1
            i+=1
        
        return True