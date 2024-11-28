class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        int cnt=0;
        for (int i = 0; i < n; i++) {
            String curr=words[i];
            for (int j = i+1; j <n ; j++) {
                StringBuilder pres = new StringBuilder(words[j]);
                if (curr.contentEquals(pres.reverse().toString())){
                 cnt++;
                }
            }
        }
        return cnt;
    }
}