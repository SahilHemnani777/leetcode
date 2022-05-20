class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1)return 0;
        int[][] dp = new int[m][n]; 
        return help(0,0, m ,n, dp, obstacleGrid);
    }
    
    public int help(int i, int j, int m, int n, int[][] dp, int[][] grid){
        
        if(i<0 || i >=m || j < 0 || j >= n|| grid[i][j]==1) return 0; // out of bounds
        
        if(i*j == (m-1)*(n-1)) return 1; // final postition
        
        if(dp[i][j] != 0) return dp[i][j];
        
        int moveDown = help(i+1, j, m, n, dp, grid);
        int moveRight = help(i, j+1, m, n, dp, grid);
        dp[i][j] = moveDown+moveRight;
        return moveDown+moveRight;
        
    }
}