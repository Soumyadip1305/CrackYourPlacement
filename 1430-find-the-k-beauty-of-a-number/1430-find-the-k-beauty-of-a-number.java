class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
    int cnt = 0;

    for (int i = 0; i <= s.length() - k; i++) {
        int curr = Integer.parseInt(s.substring(i, i + k));
        if (curr != 0 && num % curr == 0) {
            cnt++;
        }
    }

    return cnt;
    }
}