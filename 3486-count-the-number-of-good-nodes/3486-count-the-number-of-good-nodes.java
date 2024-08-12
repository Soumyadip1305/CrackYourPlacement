class Solution {

    List<Integer> adj[];
    int dist[];
    boolean vis[];
    int ans=0;

    int dfs(int src){
        int prev=-1;
        boolean equal = true;
        int size=0; vis[src] = true;
        for(int edge : adj[src]){
            if(vis[edge]) continue;
            int temp = dfs(edge);
            size += temp+1;
            if(prev==-1 || prev==temp) prev = temp;
            else equal = false;
        }
        if(equal) ans++;
        return size;
    }

    public int countGoodNodes(int[][] edges) {
        int n = edges.length;
        dist = new int[n+1];
        adj = new ArrayList[n+1];
        for(int i=0;i<=n;i++) adj[i] = new ArrayList();
        for(int i[] : edges){
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
        }
        vis = new boolean[n+1];
        dfs(0);
        return ans;
    }
}