class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i=0,j=0,n=arr.length;
        int cnt=0;
        int sum=0;
        while (j<n){
            int size=j-i+1;
            sum+=arr[j];
            if (size<k){
                j++;
            }

            if (size==k){
                int avg=sum/k;
                if (avg>=threshold){
                    cnt++;
                }
                sum-=arr[i];
                i++;j++;
            }
            if (size>k){
                i++;
            }
        }
        return cnt;
    }
}