class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null|| s.isEmpty()){
            return 0;
        }
        int i=0,j=0;
        int[]freq=new int[128];

        int maxi=0;
        while (j<s.length()){
            if (freq[s.charAt(j)]==0){
                freq[s.charAt(j)]++;
                j++;
                maxi = Math.max(maxi, j - i);
            }else {
                freq[s.charAt(i)]--;
                i++;
            }
        }
//        System.out.println(Arrays.toString(freq));
//        System.out.println(maxi);
        return maxi;
    }
}