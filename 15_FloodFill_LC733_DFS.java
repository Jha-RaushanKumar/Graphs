class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int n = image.length;
        int m = image[0].length;
        int[][] ans = image;
        int initColor = image[sr][sc];
        dfs(image,sr,sc,color,initColor,ans);
        return ans;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int initColor, int[][] ans){
        int n = image.length;
        int m = image[0].length;
        ans[sr][sc] = color;
        int[] delr = {-1,0,+1,0};
        int[] delc = {0,+1,0,-1};

        for(int i=0;i<4;i++){
            int nrow = sr+delr[i];
            int ncol = sc+delc[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol] != color && image[nrow][ncol] == initColor){
                ans[nrow][ncol] = color;
                dfs(image,nrow,ncol,color,initColor,ans);
            }
        }
    }
}