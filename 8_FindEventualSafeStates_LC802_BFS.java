class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int V = graph.length;
        ArrayList<ArrayList<Integer>> adjR = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjR.add(new ArrayList<>());
        }

        int indegree[] = new int[V];
        for(int i=0;i<V;i++){
            for(int it : graph[i]){
                adjR.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safeNodes.add(node);

            for(int it : adjR.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}