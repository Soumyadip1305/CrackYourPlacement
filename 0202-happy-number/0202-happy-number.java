class Solution {
    public boolean isHappy(int n) {
        
       int slow = n, fast = get(n);
        
        while (fast != 1 && slow != fast) {
            slow = get(slow);
            fast = get(get(fast));
        }
        
        return fast == 1;
    }

    static int  get(int n){
        int sum=0;
        while(n>0){
            int dig=(n%10);
            sum+=(dig*dig);
            n/=10;
        }
        return sum;
    }
}