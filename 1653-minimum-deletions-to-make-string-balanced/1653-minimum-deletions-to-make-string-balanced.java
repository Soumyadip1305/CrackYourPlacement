class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        //stack.push(s.charAt(s.length()-1));
        /*
        Step 1 : Start Traversal from backwards
Step 2: Push Each element in stack
Step 3 : If 'b' character appears and at peek there is 'a' ,
         Pop the stack and increase count
Step 4 : return the count;
         */
        int cnt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == 'b' && !stack.isEmpty() && stack.peek() == 'a') {
                cnt++;
                stack.pop();  
            } else {
                stack.push(ch);
            }
        }
        return cnt;
    }
}