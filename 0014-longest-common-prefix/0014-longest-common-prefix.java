public class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    public Node() {
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;  // ch - 'a' = index of the character
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
    int getLinksCount() {
        int count = 0;
        for (Node link : links) {
            if (link != null) {
                count++;
            }
        }
        return count;
    }
}

class Trie {
    private final Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) { // tc -> O(len)
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (!node.containsKey(curr)) {
                node.put(curr, new Node());  // create new Trie
            }
            node = node.get(curr); // Move to the reference node
        }
        node.setEnd();
    }

    // return word if it's present in the Trie
    boolean search(String word) {  // tc -> O(len)
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (!node.containsKey(curr)) {
                return false;
            }
            node = node.get(curr);
        }
        return node.isEnd();
    }

    // Return if there is any word in the Trie that starts with the given prefix
    boolean startsWith(String pref) {  // tc -> O(len)
        Node node = root;
        for (int i = 0; i < pref.length(); i++) {
            char curr = pref.charAt(i);
            if (!node.containsKey(curr)) {
                return false;
            }
            node = node.get(curr);
        }
        return true;
    }
    String longestCommonPrefix() {
        Node node = root;
        StringBuilder prefix = new StringBuilder();
        while (node.getLinksCount() == 1 && !node.isEnd()) {
            for (int i = 0; i < 26; i++) {
                if (node.links[i] != null) {
                    prefix.append((char) ('a' + i)); // Append the character
                    node = node.links[i]; // Move to the next node
                    break;
                }
            }
        }
        return prefix.toString();
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }
        return trie.longestCommonPrefix();
    }
}