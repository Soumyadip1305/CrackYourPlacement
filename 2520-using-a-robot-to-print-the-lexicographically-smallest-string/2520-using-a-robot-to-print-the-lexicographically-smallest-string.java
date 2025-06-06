class Solution {
    public String robotWithString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = s.length();
        char[] minRight = new char[n];
        minRight[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = (char) Math.min(s.charAt(i), minRight[i + 1]);
        }
        System.out.println(Arrays.toString(minRight));
        for (int i = 0; i < n; i++) {
            stack.push(s.charAt(i));

            while (!stack.isEmpty() && (i == n - 1 || stack.peek() <= minRight[i + 1])) {
                sb.append(stack.pop());
            }
        }

        return sb.toString();
    }
}