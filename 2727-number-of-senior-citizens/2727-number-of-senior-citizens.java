class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String it : details) {
            if (it.charAt(11) == '6' && it.charAt(12) >= '1' || it.charAt(11) > '6') {
                cnt++;
            }
        }
        return cnt;
    }
}