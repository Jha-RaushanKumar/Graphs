class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int V = graph.length;
        int[] color = new int[V];
        for(int i=0;i<V;i++){
            color[i] = -1;
        }

        for(int i=0;i<V;i++){
            if(color[i] == -1){
                if(bfs(i,color,graph) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int node, int[] color, int[][] graph) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0;
        while(!q.isEmpty()){
            int n = q.peek();
            q.remove();
            for(int it : graph[n]){
                if(color[it] == -1){
                    color[it] = 1 - color[n];
                    q.add(it);
                }
                else if(color[it] == color[n]){
                    return false;
                }
            }
        }
        return true;
    }
}