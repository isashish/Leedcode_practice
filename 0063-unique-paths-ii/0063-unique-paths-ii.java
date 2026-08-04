class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] dp = new int[row][col];
        for(int i = 0 ; i < row; i++){
            Arrays.fill(dp[i], -1);
        }

        int count = findPath(0, 0, row-1, col-1, dp, obstacleGrid);
        
        return count;
    }
    private int findPath(int sr, int sc, int er, int ec, int[][] dp, int[][] grid){
        if(sr>er || sc>ec) return 0;
        if(grid[sr][sc] == 1) return 0;
        if(sr==er && sc==ec) return 1;

        if(dp[sr][sc] != -1) return dp[sr][sc];
        
        int right = findPath(sr, sc+1, er, ec, dp, grid);
        int down = findPath(sr+1, sc, er, ec, dp, grid);

        dp[sr][sc] = right + down;

        return dp[sr][sc];
    }
}