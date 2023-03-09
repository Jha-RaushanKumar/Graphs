class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        boolean vis[][] = new boolean[n][m];
        int[][] ans = new int[n][m];
        Queue<Tuple> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    vis[i][j] = true;
                    q.add(new Tuple(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            int s = q.peek().third;
            ans[r][c] = s;
            q.remove();
            int[] delr = {-1,0,+1,0};
            int[] delc = {0,+1,0,-1};

            for(int i=0;i<4;i++){
                int nrow = r+delr[i];
                int ncol = c+delc[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == false){
                    vis[nrow][ncol] = true;
                    q.add(new Tuple(nrow,ncol,s+1));
                }
            }
        }
        return ans;
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