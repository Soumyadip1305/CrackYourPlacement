class Node{
    Node[]links=new Node[10];
    boolean flag;
    public Node() {}

    boolean containsKey(char ch){
        return links[ch-'0']!=null;
    }
    Node get(char ch){
        return links[ch-'0'];
    }
    void put(char ch,Node node){
        links[ch-'0']=node;
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}
class Trie{
    private Node root;
    public Trie() {
        root=new Node();
    }
    void insert(int n){
        Node node=root;
        String word=String.valueOf(n);
        for (int i = 0; i < word.length(); i++) {
            char curr=word.charAt(i);
            if (!node.containsKey(curr)){
                node.put(curr,new Node());
            }
            node=node.get(curr);
        }
        node.setEnd();
    }
    int longestCommPre(String word) {
        Node node = root;
        int commonLen = 0;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (node.containsKey(curr)) {
                node = node.get(curr);
                commonLen++;
            } else {
                break;
            }
        }
        return commonLen;
    }
}


public class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie=new Trie();
        for (int it : arr1) {
            trie.insert(it);
        }
        int maxi=0;
        for (int it : arr2) {
            int curr = trie.longestCommPre(String.valueOf(it));
            maxi = Math.max(maxi, curr);
        }
        return maxi;  
    }
}