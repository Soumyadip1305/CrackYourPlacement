class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> Integer.compare(a[1], b[1]));


         int s = pairs[0][1], len = 1, n = pairs.length;

         for(int i = 1; i < n; i++){
             int curF = pairs[i][0];
             int curS = pairs[i][1];

             if(curF > s){
                s = curS;
                len ++;
             }
         }

         return len;
    }
}