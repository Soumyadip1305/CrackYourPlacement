class Solution {
    public String[] divideString(String s, int k, char fill) {
         int ind = 0;
        int len = 0;
        if (s.length() % k == 0) {
            len = (s.length() / k);
        } else {
            len = (s.length() / k) + 1;
        }
        int prev = 0;
        String[] ans = new String[len];
        for (int i = 0; i < s.length(); i++) {
            if ((i + 1) % k == 0) {
                ans[ind++] = s.substring(prev, i+1);
                prev=i+1;
            }
        }
        if (prev==s.length())return ans;
//        System.out.println(prev);
//        System.out.println(Arrays.toString(ans));
        StringBuilder rem= new StringBuilder();
        for (int i = prev; i <s.length() ; i++) {
            rem.append(s.charAt(i));
        }
       // System.out.println(rem);

        rem.append(String.valueOf(fill).repeat(Math.max(0, k - rem.length())));
       // System.out.println(rem);
        ans[len-1]= rem.toString();
        return ans;
    }
}