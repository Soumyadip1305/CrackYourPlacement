class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return solve(price,special,needs,0);
    }
    static int solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs,int ind){
        int n=price.size();
        int ss=special.size();
        if(ind==ss){
            int mini=0;
            for(int i=0;i<price.size();i++){
            mini+=needs.get(i)*price.get(i);
        }
        return mini;
        }
        boolean  canTake=true;
        for(int i=0;i<n;i++){
            if(needs.get(i)<special.get(ind).get(i)){
                canTake=false;
            }
        }
        int take=Integer.MAX_VALUE;
        if(canTake){
        for(int i=0;i<n;i++){
            needs.set(i,needs.get(i)-special.get(ind).get(i));
        }
        take=special.get(ind).get(n)+solve(price,special,needs,ind);
        for(int i=0;i<n;i++){
            needs.set(i,needs.get(i)+special.get(ind).get(i));
        }
        }
        int nt=solve(price,special,needs,ind+1);
        return Math.min(take,nt);
    }
}
/*
need 3A  2B

combo-> 3A 0B  5rs
combo-> 1A 2B  10rs

poss-> 5+10=14  , 10+4=14 ,  6+10=16



*/