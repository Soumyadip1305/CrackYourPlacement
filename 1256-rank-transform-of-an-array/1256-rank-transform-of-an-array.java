class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0)return arr;
        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);
        int rank=1;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(sortArr[0],rank);
        for (int i = 1; i < arr.length; i++) {
            if (sortArr[i-1]<sortArr[i]){
                rank++;
            }
            map.put(sortArr[i],rank);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=map.get(arr[i]);
        }
        //System.out.println(map);
        return arr;
    }
}