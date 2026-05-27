class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> lower = new HashMap<>();
        HashMap<Character, Integer> upper = new HashMap<>();
        
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (Character.isLowerCase(word.charAt(i))) {
                lower.put(c, i);
            } else {
                if (!upper.containsKey(c)) {
                    upper.put(c, i);
                }
            }
        }
        
        int count = 0;
        for (HashMap.Entry<Character, Integer> entry : lower.entrySet()) {
            char key = entry.getKey();
            if (upper.containsKey(key) && entry.getValue() < upper.get(key)) {
                count++;
            }
        }
        
        return count;
    }
}