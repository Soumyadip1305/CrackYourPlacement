class Solution {
    public int[] sortArray(int[] nums) {

        Arrays.sort(nums);
         PriorityQueue<Integer>pq=new PriorityQueue<>();
        for (int it : nums) {
            pq.add(it);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]= pq.poll();
        }
    return nums;
}
}