class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums2.length + nums1.length;
        int[] brr = new int[n];
        int j = 0, i = 0, k = 0;
        while (j < nums1.length && k < nums2.length) {
            if (nums1[j] < nums2[k]) {
                brr[i++] = nums1[j];
                j++;
            } else {
                brr[i++] = nums2[k];
                k++;
            }
        }
        while (j < nums1.length) {
            brr[i++] = nums1[j];
            j++;
        }
        while (k < nums2.length) {
            brr[i++] = nums2[k];
            k++;
        }
        //System.out.println(Arrays.toString(brr));
        return (n%2!=0)?brr[(n/2)]: (double) (brr[n / 2] + brr[n / 2 - 1]) /2;
    }
}