class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) return arr;
//        int[] sortArr = arr.clone();
//        Arrays.sort(sortArr);
        int rank=1;
//        Map<Integer,Integer>map=new HashMap<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int it : arr) {
            map.put(it, 0);
        }
//        map.put(sortArr[0],rank);
        for (int it:map.keySet()) {
            map.put(it, rank++);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
        //System.out.println(map);
        return arr;
    }
}