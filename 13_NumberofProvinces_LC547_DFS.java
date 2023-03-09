class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;
                dfs(i,vis,adj);
            }
        }
        return count;
    }
    public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int it: adj.get(node)){
            if(!vis[it]){
                vis[it] = true;
                dfs(it,vis,adj);
            }
        }
    }
}