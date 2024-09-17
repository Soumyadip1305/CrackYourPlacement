class Solution {
  int[] reset;
    int[] arr;
    private Random random;

    public Solution(int[] nums) {
        this.reset = nums;
        this.arr = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return reset;
    }

    public int[] shuffle() {
        int[] newArr = arr.clone();
        for (int i = newArr.length - 1; i > 0; i--) {
            int pos = random.nextInt(i + 1);
            int temp = newArr[i];
            newArr[i] = newArr[pos];
            newArr[pos] = temp;
        }
        return newArr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */