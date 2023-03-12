class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = (int)(1e8);
        }
        dist[S]=0;
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> it : edges){
                int src = it.get(0);
                int dst = it.get(1);
                int ew = it.get(2);
                
                if(dist[src]+ew < dist[dst]){
                    dist[dst] = dist[src]+ew;
                }
            }
        }
        for(ArrayList<Integer> it : edges){
            int src = it.get(0);
            int dst = it.get(1);
            int ew = it.get(2);
                
            if(dist[src]+ew < dist[dst]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}