class Solution:
    def isPalindrome(self, s: str) -> bool:
        #t = "".join(char for char in s if char.isalnum()).lower()
        i=0
        j=len(s)-1
        while i<j:
            # 1. Skip non-alphanumeric characters from the left
            while i < j and not s[i].isalnum():
                i += 1
                
            # 2. Skip non-alphanumeric characters from the right
            while i < j and not s[j].isalnum():
                j -= 1
            if s[j].lower()!=s[i].lower():
                return False
            j-=1
            i+=1
        
        return True