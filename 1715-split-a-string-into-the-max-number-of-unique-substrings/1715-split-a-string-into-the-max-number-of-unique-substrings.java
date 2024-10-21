class Solution {
    public int maxUniqueSplit(String s) {
         return allPossibleWays(0, s, new ArrayList<>());
    }

    static int allPossibleWays(int ind, String s, ArrayList<String> list) {
        if (ind == s.length()) {
            return list.size();
        }

        int maxi = 0;
        for (int i = ind; i < s.length(); i++) {
            String subStr = s.substring(ind, i + 1);
            if (!list.contains(subStr)) {
                list.add(subStr); // take this subStr
                maxi = Math.max(maxi, allPossibleWays(i + 1, s, list)); // recursive call
                list.remove(list.size() - 1); // backtrack
            }
        }
        return maxi;
    }
}