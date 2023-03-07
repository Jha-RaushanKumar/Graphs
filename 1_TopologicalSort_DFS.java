class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        int topo[] = new int[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,st,vis,adj);
            }
        }
        int i = 0;
        while(!st.isEmpty()){
            topo[i++] = st.pop();
        }
        return topo;
    }
    static void dfs(int node, Stack<Integer> st, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                vis[it] = true;
                dfs(it, st, vis, adj);
            }
        }
        st.push(node);
    }
}