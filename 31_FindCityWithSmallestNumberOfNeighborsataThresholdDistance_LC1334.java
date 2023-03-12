class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int dist[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j){
                    dist[i][j] = 0;
                }
                else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dst = edges[i][1];
            int ew = edges[i][2];
            dist[src][dst] = ew;
            dist[dst][src] = ew;
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][via] == Integer.MAX_VALUE || dist[via][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                }
            }
        }
        int cntMax=n;
        int cityAns = -1;
        for(int city=0;city<n;city++){
            int cnt = 0;
            for(int adjCity=0;adjCity<n;adjCity++){
                if(dist[city][adjCity] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <=cntMax){
                cntMax = cnt;
                cityAns = city;
            }
        }
        return cityAns;
    }
}