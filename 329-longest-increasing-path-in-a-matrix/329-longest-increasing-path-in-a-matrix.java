class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int LIP = 1;
        int rows = matrix.length;
        int columns = matrix[0].length;
            int[][] dp = new int[rows][columns];
        for(int r = 0; r<rows; r++){
            for(int c=0; c<columns; c++){
                LIP = Math.max(LIP, dynamicDFS(r,c,rows, columns, -1, dp, matrix));
            }
        }
        return LIP;
    }
    
    public int dynamicDFS(int r, int c, int rows, int columns, int prevValues, int[][] dp, int[][] matrix){
        if(r <0 || r == rows || c<0 || c == columns || matrix[r][c] <= prevValues)return 0;
        if(dp[r][c]!=0) return dp[r][c];
        int res = 1;
        res = Math.max(res, 1 + dynamicDFS(r+1, c, rows, columns, matrix[r][c], dp, matrix));
        res = Math.max(res, 1 + dynamicDFS(r-1, c, rows, columns, matrix[r][c], dp, matrix));
        res = Math.max(res, 1 + dynamicDFS(r, c+1, rows, columns, matrix[r][c], dp, matrix));
        res = Math.max(res, 1 + dynamicDFS(r, c-1, rows, columns, matrix[r][c], dp, matrix));
        dp[r][c] = res;
        return res;
    }
}