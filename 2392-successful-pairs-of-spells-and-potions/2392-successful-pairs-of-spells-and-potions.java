class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] cnt = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            cnt[i] =potions.length- solve(spells[i], potions, success);
        }
        System.out.println(Arrays.toString(cnt));
        return cnt;
    }

    static int solve(int x, int[] potions, long tar) {
        int low = 0, high = potions.length-1,ans= potions.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((long) potions[mid] *x>=tar){
                ans=mid;
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return ans;
    }
}