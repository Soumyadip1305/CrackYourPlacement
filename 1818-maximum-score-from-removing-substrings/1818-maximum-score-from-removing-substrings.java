class Solution {
    public int maximumGain(String s, int x, int y) {
        /*  return (x >= y) ? removeSubstrings(s, "ab", x, "ba", y) : removeSubstrings(s, "ba", y, "ab", x);
    }

    private static int removeSubstrings(String s, String firstSubstr, int firstPoints, String secondSubstr, int secondPoints) {
        int pnt = 0;
        StringBuilder sb = new StringBuilder(s);
        // Remove firstSubstr (either "ab" or "ba")
        pnt += cnt(sb, firstSubstr, firstPoints);
        // remove remaining one
        pnt += cnt(sb, secondSubstr, secondPoints);
        return pnt;
    }

    private static int cnt(StringBuilder sb, String substr, int points) {
        int totPoint = 0;
        int i;
        // Remove all occurrences of the given substring
        while ((i = sb.indexOf(substr)) != -1) {
            sb.delete(i, i + 2);
            totPoint += points;
        }
        return totPoint;
    }
    */
    return (x >= y) ? removeSubstrings(s, "ab", x, "ba", y) : removeSubstrings(s, "ba", y, "ab", x);
    }

    private static int removeSubstrings(String s, String firstSubstr, int firstPoints, String secondSubstr, int secondPoints) {
        int points = 0;
        Stack<Character> stack = new Stack<>();

        // Remove firstSubstr (more valuable one) first
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == firstSubstr.charAt(0) && c == firstSubstr.charAt(1)) {
                stack.pop();
                points += firstPoints;
            } else {
                stack.push(c);
            }
        }

        // Collect remaining characters
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        // Remove secondSubstr
        for (char ch : sb.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == secondSubstr.charAt(0) && ch == secondSubstr.charAt(1)) {
                stack.pop();
                points += secondPoints;
            } else {
                stack.push(ch);
            }
        }

        return points;
    }
}