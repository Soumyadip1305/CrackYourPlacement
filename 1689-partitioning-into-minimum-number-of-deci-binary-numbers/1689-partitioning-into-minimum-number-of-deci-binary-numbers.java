class Solution {
    public int minPartitions(String n) {
        int maxi=-1;
        for (int i = 0; i < n.length(); i++) {
            maxi=Math.max(maxi,n.charAt(i)-'0');
            if(maxi==9)return maxi;
        }
        return maxi;
    }
}