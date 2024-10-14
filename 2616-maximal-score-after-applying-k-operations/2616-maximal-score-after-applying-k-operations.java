class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b.compareTo(a));
        for (int it:nums)pq.add(it);
        //System.out.println(pq.poll());
        //System.out.println(pq);
        while (!pq.isEmpty()&&k>0){
            int curr=pq.poll();
            ans+=curr;
            k--;
            pq.add((int) Math.ceil((double) curr /3));
        }

        return ans;
    }
}