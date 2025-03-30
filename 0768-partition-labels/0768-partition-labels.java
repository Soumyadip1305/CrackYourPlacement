class Solution {
    public List<Integer> partitionLabels(String s) {
       int[] last = new int[26];
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> ans = new ArrayList<>();
        int start = 0, maxLast = 0;
        
        for (int i = 0; i < n; i++) {
            maxLast = Math.max(maxLast, last[s.charAt(i) - 'a']);
            if (i == maxLast) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        
        return ans; 
    }
}