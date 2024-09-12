class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character>set=new HashSet<>();
        for (char ch:allowed.toCharArray()) {
            set.add(ch);
        }int cnt=0;
        for (String it : words) {
            boolean flag = true;
            for (char ch : it.toCharArray()) {
                if (!set.contains(ch)) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }
}