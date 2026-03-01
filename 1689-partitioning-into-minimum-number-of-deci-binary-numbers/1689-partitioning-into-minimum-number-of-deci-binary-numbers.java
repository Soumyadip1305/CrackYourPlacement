class Solution {
    public int minPartitions(String n) {
        int maxi = 0;

    for (int i = 0; i < n.length(); i++) {
        int digit = n.charAt(i) - '0';
        if (digit > maxi) {
            maxi = digit;
            if (maxi == 9) return 9;   // early exit
        }
    }
    return maxi;
    }
}