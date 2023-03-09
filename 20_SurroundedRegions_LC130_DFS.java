class Solution {
    public void solve(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs(i,0,vis,board);
            }
            if(!vis[i][m-1] && board[i][m-1] == 'O'){
                dfs(i,m-1,vis,board);
            }
        }
        for(int i=0;i<m;i++){
            if(!vis[0][i] && board[0][i] == 'O'){
                dfs(0,i,vis,board);
            }
            if(!vis[n-1][i] && board[n-1][i] == 'O'){
                dfs(n-1,i,vis,board);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == false && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int r, int c, boolean[][] vis, char[][] board){
        int n = board.length;
        int m = board[0].length;
        vis[r][c] = true;
        int[] delr = {-1,0,+1,0};
        int[] delc = {0,+1,0,-1};

        for(int i=0;i<4;i++){
            int nrow = r+delr[i];
            int ncol = c+delc[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == false && board[nrow][ncol] == 'O'){
                vis[nrow][ncol] = true;
                dfs(nrow,ncol,vis,board);
            }
        }

    }
}