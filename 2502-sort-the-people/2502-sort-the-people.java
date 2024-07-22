class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
          String[] ans = new String[heights.length];
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        System.out.println(map);
        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            ans[heights.length-i-1] = map.get(heights[i]);
        }
        return ans;
    }
}