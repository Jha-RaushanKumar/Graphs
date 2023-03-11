class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.second - b.second);
        int dist[] = new int[n+1];
        for(int i=0;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        q.add(new Pair(k,0));

        while(!q.isEmpty()){
            int node = q.peek().first;
            int dis = q.peek().second;
            q.remove();
            for(Pair it : adj.get(node)){
                int neigh = it.first;
                int ew = it.second;

                if(dis+ew < dist[neigh]){
                    dist[neigh] = dis+ew;
                    q.add(new Pair(neigh,dis+ew));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max,dist[i]);
        }
        return max;
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