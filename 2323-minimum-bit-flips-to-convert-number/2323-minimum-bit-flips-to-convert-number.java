class Solution {
    public int minBitFlips(int start, int goal) {
        /*String a=Integer.toBinaryString(start);
        String b=Integer.toBinaryString(goal);
        int cnt=0;
        int al=a.length(),bl=b.length();
        String aa="";
        String bb="";
        while (al<bl){
            aa+='0';
            al++;
        }
        while (bl <al){
            bb+='0';
            bl++;
        }
        aa+=a;
        bb+=b;
      //  System.out.println(aa+" "+ bb);
        for (int i = 0; i < aa.length(); i++) {
          if (aa.charAt(i)!=bb.charAt(i)){
              cnt++;
          }
        }
        return cnt;
        */
        return Integer.bitCount(start^goal);
    }
}