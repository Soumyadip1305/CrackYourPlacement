class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int maxVal = 1000; 
    int[] count = new int[maxVal + 1];

    for (int it : target) {
        count[it]++;
    }

    for (int it : arr) {
        count[it]--;
    }

    for (int i = 0; i <= maxVal; i++) {
        if (count[i] != 0) {
            return false;
        }
    }

    return true;
    }
}