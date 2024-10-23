class Solution {
    public int distMoney(int money, int children) {
        if (money < children) return -1;

    money -= children;
    
    int cnt = Math.min(money / 7, children);
    money -= cnt * 7;
    children -= cnt;
    
    if (children == 0 && money > 0) return cnt - 1;
    if (children == 1 && money == 3) return cnt - 1;
    
    return cnt;
    }
}
/*

nobody can take 4 dolor
*/