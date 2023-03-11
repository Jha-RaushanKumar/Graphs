class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        
        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[S] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.second - b.second);
        q.add(new Pair(S,0));
        
        while(!q.isEmpty()){
            int node = q.peek().first;
            int dis = q.peek().second;
            q.remove();
            for(ArrayList<Integer> it: adj.get(node)){
                int neigh = it.get(0);
                int ew = it.get(1);
                
                if(dis+ew < dist[neigh]){
                    dist[neigh] = dis+ew;
                    q.add(new Pair(neigh,dis+ew));
                }
            }
        }
        return dist;
    }
}
class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}