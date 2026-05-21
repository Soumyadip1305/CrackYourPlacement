class Solution {
    static class Trie {
        Trie[] ele = new Trie[10];

        void insert(int x) {
            String s = String.valueOf(x);
            Trie node = this;

            for (int i = 0; i < s.length(); i++) {
                int ind = s.charAt(i) - '0';
                if (node.ele[ind] == null) {
                    node.ele[ind] = new Trie();
                }
                node = node.ele[ind];
            }
        }

        int commonPrefix(int x) {
            String s = String.valueOf(x);
            Trie node = this;
            int len = 0;

            for (int i = 0; i < s.length(); i++) {
                int ind = s.charAt(i) - '0';

                if (node.ele[ind] == null) {
                    break;
                }

                node = node.ele[ind];
                len++;
            }

            return len;
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();

        for (int x : arr1) {
            trie.insert(x);
        }

        int ans = 0;

        for (int x : arr2) {
            ans = Math.max(ans, trie.commonPrefix(x));
        }

        return ans;
    }

}