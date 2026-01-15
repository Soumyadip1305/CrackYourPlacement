class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int tCnt = 0,i=0, fCnt = 0, ans = 1, maxi = 1;

        for (int j = 0; j < answerKey.length(); j++) {
            char ch = answerKey.charAt(j);
            if (ch == 'T') tCnt++;
            else fCnt++;
            maxi=Math.max(maxi,Math.max(fCnt,tCnt));

            while (j-i+1-maxi>k){
                if (answerKey.charAt(i) == 'T') tCnt--;
                else fCnt--;
                i++;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}