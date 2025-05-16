import java.util.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<Integer> resultIndices = findLongestSubsequence(0, -1, words, groups, new HashMap<>());
        List<String> ans = new ArrayList<>();
        for (int index : resultIndices) {
            ans.add(words[index]);
        }
        return ans;
    }

    private boolean isValidEditDistance(String a, String b) {
        if (a.length() != b.length()) return false;
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }

    private List<Integer> findLongestSubsequence(int i, int prev, String[] words, int[] groups, Map<String, List<Integer>> memo) {
        if (i == words.length) return new ArrayList<>();

        String key = i + "," + prev;
        if (memo.containsKey(key)) return memo.get(key);

        // Option 1: not take
        List<Integer> notTake = findLongestSubsequence(i + 1, prev, words, groups, memo);

        // Option 2: take if valid
        List<Integer> take = new ArrayList<>();
        if (prev == -1 || (groups[prev] != groups[i] && isValidEditDistance(words[prev], words[i]))) {
            take.add(i);
            take.addAll(findLongestSubsequence(i + 1, i, words, groups, memo));
        }

        List<Integer> result = (take.size() > notTake.size()) ? take : notTake;
        memo.put(key, result);
        return result;
    }
}
