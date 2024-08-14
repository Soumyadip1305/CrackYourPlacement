class Solution {
    public int maximumGroups(int[] grades) {
        
        int l=1,h=grades.length,ans=0;

        while(h>=l){
             int m = l + (h - l) / 2;
            long sum = (long) m * (m + 1) / 2;

            if (sum <= grades.length) {
                ans = m;  
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return ans;
        }
    }