class Solution {
    public int minimumPushes(String word) {
         List<Character> list = solve(word);

        int prev = 0;
        int pres = 1;
        int next = 2;

        for (char ch : list) {
            prev += word.chars().filter(c -> c == ch).count() * pres;
            if (next < 9) {
                next++;
            } else {
                next = 2;
                pres++;
            }
        }

        return prev;
    }
    public static List<Character> solve(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map.keySet().stream().sorted((a, b) -> map.get(b) - map.get(a)).collect(Collectors.toList());
    }
}