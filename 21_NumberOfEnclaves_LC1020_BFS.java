class Solution {
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(grid[i][j] == 1){
                        vis[i][j] = true;
                        q.add(new Pair(i,j));
                    }
                }
            }        
        }
        while(!q.isEmpty()){
            int sr = q.peek().first;
            int sc = q.peek().second;
            q.remove();
            int delr[] = {-1,0,1,0};
            int delc[] = {0,1,0,-1};
            
            for(int i=0;i<4;i++){
                int nrow = sr+delr[i];
                int ncol = sc+delc[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
        int count= 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j] == false){
                    count++;
                }
            }        
        }
        return count;
    }
}
class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}