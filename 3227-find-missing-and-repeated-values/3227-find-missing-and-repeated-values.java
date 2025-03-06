class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int[]ans=new int[2];
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<grid[0].length;j++){
                int x=grid[i][j];
                if(set.contains(x)){
                    ans[0]=x;
                }else{
                    set.add(x);
                }
            }
        }
        for(int i=1;i<=n*n;i++){
            if(!set.contains(i)){
                ans[1]=i;
            }
        }
        return ans;
    }
}