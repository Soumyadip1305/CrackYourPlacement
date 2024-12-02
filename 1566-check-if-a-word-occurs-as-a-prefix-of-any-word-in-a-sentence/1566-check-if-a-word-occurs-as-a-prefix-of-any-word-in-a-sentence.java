class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[]str=sentence.split(" ");
        for (int i = 0; i < str.length; i++) {
            String curr=str[i];
            if (curr.startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }
}