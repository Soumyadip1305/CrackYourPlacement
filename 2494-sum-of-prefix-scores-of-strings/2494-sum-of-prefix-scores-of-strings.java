class Solution {
   static class Node {
        Node[] links = new Node[26];
        int visCnt = 0;

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }
    }

    static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
                node.visCnt++;
            }
        }
        int totalSum(String word) {
            Node node = root;
            int cnt=0;
            for (char ch : word.toCharArray()) {
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                    cnt += node.visCnt;
                }
            }
            return cnt;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
       // System.out.println(trie.totalSum(words[3]));
        int[]ans=new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ans[i]=trie.totalSum(words[i]);
        }
        return ans;
    }
}