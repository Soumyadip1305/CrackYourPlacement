class Solution {
    public int maximum69Number (int num) {
        
        String s=Integer.toString(num);
        String ans="";
        int i=0;
        for(;i<s.length();i++){
            if(s.charAt(i)=='6'){
                ans+='9';
                break;
            }
            ans+='9';
        }
        i++;
        for(;i<s.length();i++){
            ans+=s.charAt(i);
        }
        return Integer.parseInt(ans);
    }
}