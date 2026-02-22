class Solution {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);

        int maxi = 0, l = 0;boolean lp=false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && lp) {
                maxi=Math.max(i-l,maxi);
                l=i;
            }else if(s.charAt(i) == '1' && !lp){
                lp=true;
                l=i;
            }
        }
        return maxi;
    }
}