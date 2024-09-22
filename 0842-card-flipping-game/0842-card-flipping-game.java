class Solution {
    public int flipgame(int[] fronts, int[] backs) {
      // Map<Integer, Integer> map = new HashMap<>();
        //if(back !== front) set contains
        TreeSet<Integer> set=new TreeSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i]==backs[i]) {
                set.add(fronts[i]);
            }
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < backs.length; i++) {
            if (!set.contains(backs[i]) ) {
                mini = Math.min(mini,backs[i]);
            }
            if (!set.contains(fronts[i]) ) {
                mini = Math.min(mini,fronts[i]);
            }
        }
        return mini==Integer.MAX_VALUE?0:mini;
    }
}