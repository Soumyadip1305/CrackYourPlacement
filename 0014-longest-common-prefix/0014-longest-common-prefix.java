public class Node {
    Node[] links = new Node[26];
    boolean flag = false;
    int linkCount = 0; // Track the number of links

    public Node() {
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
        linkCount++; // Increment the link count when a new link is added
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }

    int getLinksCount() {
        return linkCount; // Return the pre-tracked link count
    }
}

class Trie {
    private final Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) { // O(len)
        Node node = root;
        for (char curr : word.toCharArray()) {
            if (!node.containsKey(curr)) {
                node.put(curr, new Node());  // Create new Trie node
            }
            node = node.get(curr); // Move to the reference node
        }
        node.setEnd();
    }

    boolean search(String word) { // O(len)
        Node node = root;
        for (char curr : word.toCharArray()) {
            if (!node.containsKey(curr)) {
                return false;
            }
            node = node.get(curr);
        }
        return node.isEnd();
    }

    boolean startsWith(String pref) { // O(len)
        Node node = root;
        for (char curr : pref.toCharArray()) {
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
                    break; // Move out of the loop once the link is found
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
