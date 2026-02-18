class Solution {
    public boolean hasAlternatingBits(int n) {
    /*    String s=Integer.toBinaryString(n);

        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==s.charAt(i))return false;
        }
        return true;*/

        n^=(n>>1);
        return (n & (n+1))==0;
    }
}
/*
  2  5 10 21 42 85  170 341  

  2*prev+1=next not alternative 


 5-> 101  -> right shieft 1 -> 010 should be xor should be all 1 =111
now n=7 111

so 7->111->110  n=111^011=100
n&(n+1)=> 110&111=0?


so 111 & 1000=0
  2->01->10 n=01^10=11
  ans=n&(n+1)=11&100=0 always 
*/