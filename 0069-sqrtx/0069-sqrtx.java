class Solution {
    public int mySqrt(int x) {
      int low = 1, high = x;
        if (x==0)return 0;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            int curr = x / mid;
            if (curr == mid) {
                return mid;
            } else if (curr > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
//        System.out.println(Math.sqrt(4));
//        System.out.println(high);
        return high;
    }
}