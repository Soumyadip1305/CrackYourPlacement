class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String it : details) {
            String age = it.substring(11, 13);
            if (Integer.parseInt(age) > 60) cnt++;
        }
        return cnt;
    }
}