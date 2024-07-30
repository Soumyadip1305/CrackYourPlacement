class Solution {
    public boolean canAliceWin(int[] nums) {
      int one = 0, two = 0;
        for (int it : nums) {
            if (checkLength(it)) {
                one+=it;
            } else {
                two+=it;
            }
        }
       // System.out.println(one+" "+two);
        return Math.max(one,two)!=Math.min(one,two);
    }

    static boolean checkLength(int n) {
        return Integer.toString(n).length()<2;
    }
}