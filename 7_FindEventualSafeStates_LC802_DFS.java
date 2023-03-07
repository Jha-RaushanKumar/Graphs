class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        boolean check[] = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,pathVis,check,graph);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    public boolean dfs(int node, boolean vis[], boolean pathVis[], boolean check[], int[][] graph) {
        
        vis[node] = true;
        pathVis[node] = true;
        for(int it : graph[node]){
            if(!vis[it]){
                if(dfs(it,vis,pathVis,check,graph) == true){
                    return true;
                }
            }
            else if(pathVis[it] == true){
                return true;
            }
        }
        pathVis[node] = false;
        check[node] = true;
        return false;
    }
}