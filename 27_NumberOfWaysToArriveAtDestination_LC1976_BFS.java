class Solution {
    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        int dist[] = new int[n];
        int ways[] = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        ways[0] = 1;
        int mod = (int)(Math.pow(10,9)+7);
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.second - b.second);
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            int node = q.peek().first;
            int dis = q.peek().second;
            q.remove();

            for(Pair it : adj.get(node)){
                int neigh = it.first;
                int ew = it.second;

                if(ew+dis < dist[neigh]){
                    dist[neigh] = ew+dis;
                    q.add(new Pair(neigh,ew+dis));
                    ways[neigh] = (ways[node]) % mod;
                }
                else if(ew+dis == dist[neigh]){
                    ways[neigh] = (ways[neigh] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
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