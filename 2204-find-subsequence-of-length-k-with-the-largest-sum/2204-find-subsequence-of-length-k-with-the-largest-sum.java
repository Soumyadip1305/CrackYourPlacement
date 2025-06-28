class Solution {
    static class Pair {
    int val, ind;
    Pair(int val, int ind) {
        this.val = val;
        this.ind = ind;
    }
}
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.val - a.val
        );
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
        }
        int[]ans=new int[k];
        List<List<Integer>> list = new ArrayList<>();
        while(k>0&&!pq.isEmpty()){
            Pair pair=pq.poll();
            list.add(Arrays.asList(pair.ind, pair.val));
            k--;
        }
        list.sort(Comparator.comparingInt(a -> a.get(0)));
         for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i).get(1);
        }
        return ans;
    }
}