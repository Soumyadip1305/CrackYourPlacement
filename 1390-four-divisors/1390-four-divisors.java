class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
    for (int x : nums) {
        ans += fourDivSum(x);
    }
    return ans;
}

static int fourDivSum(int n){
    int cnt = 0;
    int sum = 0;
    for (int i = 1; i * i <= n; i++){
        if (n % i == 0){
            int j = n / i;
            cnt++;
            sum += i;
            if (i != j){
                cnt++;
                sum += j;
            }
            if (cnt > 4) return 0;
        }
    }
    return cnt == 4 ? sum : 0;
    }
}