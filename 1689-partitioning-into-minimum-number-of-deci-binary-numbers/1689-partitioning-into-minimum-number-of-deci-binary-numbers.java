class Solution {
    public int minPartitions(String n) {
        int maxi=-1;
        for (int i = 0; i < n.length(); i++) {
            maxi=Math.max(maxi,Integer.parseInt(String.valueOf(n.charAt(i))));
        }
        return maxi;
    }
}