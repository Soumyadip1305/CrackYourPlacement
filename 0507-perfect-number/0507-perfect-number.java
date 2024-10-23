class Solution {
    public boolean checkPerfectNumber(int num) {
        int[] perfectNumbers = {6, 28, 496, 8128, 33550336};
    
    for (int perfect : perfectNumbers) {
        if (num == perfect) {
            return true;
        }
    }
    return false;
    }
}