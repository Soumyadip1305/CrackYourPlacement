class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int it : answers) map.put(it, map.getOrDefault(it, 0) + 1);

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            cnt += Math.ceil((double)entry.getValue() / (entry.getKey() + 1)) * (entry.getKey() + 1);

        return cnt;
    }
}