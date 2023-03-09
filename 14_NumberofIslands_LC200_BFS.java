class Solution {
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count = 0;
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    count++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return count;
    }

    public void bfs(int row, int col, boolean vis[][], char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));

        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();
            int[] delr = {-1,0,+1,0};
            int[] delc = {0,+1,0,-1};

            for(int i=0;i<4;i++){
                int nrow = r+delr[i];
                int ncol = c+delc[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == false && grid[nrow][ncol] == '1'){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
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