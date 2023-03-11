class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        HashSet< ArrayList<String>> set = new HashSet<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    ArrayList<String> ls = new ArrayList<>();
                    dfs(i,j,vis,ls,grid,i,j);
                    set.add(ls);
                }
            }
        }
        return set.size();
    }
    public void dfs(int row, int col, boolean[][] vis, ArrayList<String> ls, int[][] grid, int row0, int col0){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = true;
        ls.add((row0-row)+" "+(col0-col));
        
        int delr[] = {-1,0,1,0};
        int delc[] = {0,1,0,-1};
            
        for(int i=0;i<4;i++){
            int nrow = row+delr[i];
            int ncol = col+delc[i];
                
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                dfs(nrow,ncol,vis,ls,grid,row0,col0);
            }
        }
    }
}