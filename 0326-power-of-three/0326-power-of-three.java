class Solution {
    public boolean isPowerOfThree(int n) {
        while (n>0){
            if (n%3==0) {
                n /= 3;
            }else break;
        }
        //System.out.println(n);
        return n==1;
    }
}