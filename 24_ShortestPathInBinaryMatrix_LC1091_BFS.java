class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1){
            return -1;
        }

        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        PriorityQueue<Tuple> q = new PriorityQueue<>((a,b) -> a.third - b.third);
        q.add(new Tuple(0,0,1));
        dist[0][0] = 1;

        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            int dis = q.peek().third;
            q.remove();

            if(r == n-1 && c == m-1){
                return dis;
            }

            for(int delr=-1;delr<=1;delr++){
                for(int delc=-1;delc<=1;delc++){
                    int nrow = r+delr;
                    int ncol = c+delc;

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0){
                        if(dis+1<dist[nrow][ncol]){
                            dist[nrow][ncol] = dis+1;
                            q.add(new Tuple(nrow,ncol,dis+1));
                        }
                    }
                }
            }
        }
        return -1;
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