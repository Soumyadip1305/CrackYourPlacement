class MapSum {
    static class Node {
        Node[] links = new Node[26];
        int val=0;
        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        void put(char ch,Node node){
            links[ch-'a']=node;
        }
        Node get(char ch){
            return links[ch-'a'];
        }
    }
    Node root;
    Map<String, Integer> map;
    public MapSum() {
        root=new Node();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0); // Calculate the difference with previous value
        map.put(key, val);
        Node node=root;
        for (char ch:key.toCharArray()){
            if (!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node=node.get(ch);
            node.val+=diff;
        }
    }

    public int sum(String prefix) {
        Node node=root;
        for (char ch:prefix.toCharArray()){
            if (node.containsKey(ch)){
                node=node.get(ch);
            }else return 0;
        }
        return node.val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */