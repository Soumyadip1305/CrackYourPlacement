class Solution {
    public String reverseWords(String s) {
         String[]arr=s.trim().split("\\s+");
        StringBuilder ans=new StringBuilder();
         System.out.println(Arrays.toString(arr));
         int n=arr.length;
        for (int i = 0; i <n-1; i++) {
            ans.append(arr[n-i-1]);
            ans.append(" ");
        }
        ///System.out.println(ans);
        return ans+arr[0];
    }
}