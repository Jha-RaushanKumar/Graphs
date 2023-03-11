class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        int dist[] = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Tuple> q = new LinkedList<>();
        //stops,source,cost
        q.add(new Tuple(0,src,0));
        dist[src]=0;

        while(!q.isEmpty()){
            int stops = q.peek().first;
            int node = q.peek().second;
            int cost = q.peek().third;
            q.remove();
            if(stops>k){
                continue;
            }
            for(Pair it : adj.get(node)){
                int neigh = it.first;
                int ew = it.second;

                if(ew+cost<dist[neigh] && stops<=k){
                    dist[neigh] = ew+cost;
                    q.add(new Tuple(stops+1,neigh,ew+cost));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];   
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
class Tuple{
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}