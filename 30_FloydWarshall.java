class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(matrix[i][via] == Integer.MAX_VALUE || matrix[via][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via]+matrix[via][j]);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == Integer.MAX_VALUE){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}