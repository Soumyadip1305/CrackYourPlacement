class Solution {
    public boolean canTransform(String start, String result) {
        int n = start.length();
        int m = result.length();

        if (n != m) return false;
        if (!start.replace("X", "").equals(result.replace("X", ""))) return false;

        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && result.charAt(j) == 'X') j++;

            if (i == n && j == n) break;

            if (i == n || j == n) return false;

            if (start.charAt(i) != result.charAt(j)) return false;

            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }

        return true;
        
    }
}