class Solution {
    public String largestGoodInteger(String num) {
        for(int i=999;i>=100;i--){
            String s=String.valueOf(i);
            if(num.indexOf(s)>=0) return s;
            i=i-111+1;
        }
        if(num.indexOf("000")>=0) return "000";
        return "";
    }
}