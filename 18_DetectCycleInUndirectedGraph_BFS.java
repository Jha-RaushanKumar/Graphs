class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                vis[i] = true;
                if(bfs(i,-1,vis,adj) == true){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean bfs(int node,int p, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node,p));
        while(!q.isEmpty()){
            int src = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            
            for(int it : adj.get(src)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(new Pair(it,src));
                }
                else if(it != parent){
                    return true;
                }
            }
        }
        return false;
    }
}
class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}