class WordDictionary {
    static class Node {
      Node[] links = new Node[26];
        boolean flag = false;

        boolean containsKey(char ch) {
            return links[ch - 'a'] == null;
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.flag = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int ind, Node node) {
        if (ind == word.length()) {
            return node.flag;
        }

        char ch = word.charAt(ind);
        if (ch == '.') {
            for (Node child : node.links) {
                if (child != null && searchHelper(word, ind + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.containsKey(ch)) {
                return false;
            }
            return searchHelper(word, ind + 1, node.get(ch));
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */