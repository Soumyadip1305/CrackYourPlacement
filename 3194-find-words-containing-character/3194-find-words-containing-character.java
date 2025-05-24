class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String str=words[i];
            for(char ch:str.toCharArray()){
                if(ch==x){
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}