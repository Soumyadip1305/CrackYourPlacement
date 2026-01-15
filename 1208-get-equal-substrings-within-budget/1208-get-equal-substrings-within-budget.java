class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int[]diff=new int[n];
        for (int i = 0; i < n; i++) {
            diff[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        int sum=0,ans=0,i=0;
        for (int j = 0; j < n; j++) {
            sum+=diff[j];

            while (sum>maxCost){
                sum-=diff[i];
                i++;
            }
            ans=Math.max(ans,j-i+1);
        }

        //System.out.println(Arrays.toString(diff));
        return ans;
    }
}