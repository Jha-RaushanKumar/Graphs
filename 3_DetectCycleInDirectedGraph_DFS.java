class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,vis,pathVis,adj) == true){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int node, boolean vis[], boolean pathVis[], ArrayList<ArrayList<Integer>> adj) {
        // code here
        vis[node] = true; 
        pathVis[node] = true;
        
        for(int it : adj.get(node)){
            if(!vis[it]){
                if(dfs(it,vis,pathVis,adj) == true){
                    return true;
                }
            }
            else if(pathVis[it]){
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}