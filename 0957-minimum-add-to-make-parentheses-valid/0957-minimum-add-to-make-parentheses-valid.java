class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>stack=new Stack<>();
        int cnt=0;
        for(char ch:s.toCharArray()){
            if (ch==')'){
                if (!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                }else {
                    cnt++;
                }
            }else {
                stack.push(ch);
            }
        }
        //System.out.println(stack);
        return stack.size()+cnt;
    }
}