class Solution {
    public boolean isPerfectSquare(int x) {
        int curr=x;

        while((long)curr*curr>x){
            curr=(curr+x/curr)/2;
        }
        return (long)curr*curr==x;
    }
}