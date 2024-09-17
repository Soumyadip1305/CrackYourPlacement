class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
       Map<String, Integer> map = new HashMap<>();
    String[] s11 = s1.split(" ");
    String[] s22 = s2.split(" ");
    
    for (String word : s11) {
        map.put(word, map.getOrDefault(word, 0) + 1);
    }

    for (String word : s22) {
        map.put(word, map.getOrDefault(word, 0) + 1);
    }

    List<String> ans = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 1) {
            ans.add(entry.getKey());
        }
    }

    return ans.toArray(new String[0]);
    }
}