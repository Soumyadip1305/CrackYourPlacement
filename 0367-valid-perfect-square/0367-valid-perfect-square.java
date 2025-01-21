class Solution {
    public boolean isPerfectSquare(int x) {
        long curr=x;

        while(curr*curr>x){
            curr=(curr+x/curr)/2;
        }
        return curr*curr==x;
    }
}