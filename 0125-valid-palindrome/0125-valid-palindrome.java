class Solution {
    public boolean isPalindrome(String s) {
         String str="";

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                str += Character.toLowerCase(s.charAt(i));
            }
        }
        System.out.println(str);
        return isValid(str.toLowerCase());
    }
    static boolean isValid(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}