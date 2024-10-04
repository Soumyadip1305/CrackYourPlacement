class Solution {
    public long dividePlayers(int[] skill) {
        int n=skill.length;
        if (n==2)return (long) skill[0] *skill[1];
        int teams=n/2;
        Arrays.sort(skill);
        int low=1,high=n-2;
        long prev=skill[0]+skill[n-1];
        long ans= (long) skill[0] *skill[n-1];
        while (teams>1&&low<high){
            long curr=skill[low]+skill[high];
            if (curr!=prev)return -1;
            else ans+=((long) skill[low] *skill[high]);
            low++;high--;teams--;
        }
        return ans;
    }
}