class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;

        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        PriorityQueue<Tuple> q = new PriorityQueue<>((a,b) -> a.third - b.third);
        q.add(new Tuple(0,0,0));

        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            int eff = q.peek().third;
            q.remove();
            if(r == n-1 && c == m-1){
                return eff;
            }
            int[] delr = {-1,0,1,0};
            int[] delc = {0,1,0,-1};

            for(int i=0;i<4;i++){
                int nrow = r +delr[i];
                int ncol = c +delc[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int neweff = Math.max(Math.abs(heights[r][c]-heights[nrow][ncol]),eff);
                    if(neweff < dist[nrow][ncol]){
                        dist[nrow][ncol] = neweff;
                        q.add(new Tuple(nrow,ncol,neweff));
                    }
                }
            }
        }
        return 0;
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