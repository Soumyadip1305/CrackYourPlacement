class Solution {
    public String reverseParentheses(String s) {
      Stack<Character> stack = new Stack<>();
        int cnt=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==')'){
                StringBuilder sb=new StringBuilder();
                while (!stack.isEmpty()&&stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
                // push element  stack in reverse order
                for (int j = 0; j < sb.length(); j++) {
                    stack.push(sb.charAt(j));
                }
            }
            else stack.push(s.charAt(i));
        }
//        System.out.println(stack);
//        System.out.println();
        String ans="";
        for (char ch:stack)ans+=ch;
        return ans;  
    }
}