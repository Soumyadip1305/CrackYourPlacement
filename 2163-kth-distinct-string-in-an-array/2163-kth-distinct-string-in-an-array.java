class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String it : arr) {
            map.put(it, map.getOrDefault(it, 0) + 1);
        }
        for (String it : arr) {
            if (map.get(it) == 1) {
                if (k == 1) return it;
                else k--;
            }
        }
      //  System.out.println(k);
      //  System.out.println(map);
        return "";
    }
}