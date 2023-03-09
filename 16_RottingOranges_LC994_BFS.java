class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        Queue<Tuple> q = new LinkedList<>();
        int cntFresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    vis[i][j] = true;
                    q.add(new Tuple(i,j,0));
                }
                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }
        int tmax = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            int t = q.peek().third;
            tmax = Math.max(tmax,t);
            q.remove();
            int[] delr = {-1,0,+1,0};
            int[] delc = {0,+1,0,-1};

            for(int i=0;i<4;i++){
                int nrow = r+delr[i];
                int ncol = c+delc[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == false && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = true;
                    cnt++;
                    q.add(new Tuple(nrow,ncol,t+1));
                }
            }
        }
        if(cntFresh != cnt){
            return -1;
        }
        return tmax;
    }
}
class Tuple{
    int first;
    int second;
    int third;

    public Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}