class Solution {
    public int uniquePaths(int m, int n) {
        int row = m;
        int col = n;

        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        int count = findPath(0, 0, row-1, col-1, dp);
        
        return count;
    }
    private int findPath(int sr, int sc, int er, int ec, int[][] dp){
        if(sr>er || sc>ec) return 0;
        if(sr==er && sc==ec) return 1;

        if(dp[sr][sc] != -1) return dp[sr][sc];
        
        int right = findPath(sr, sc+1, er, ec, dp);
        int down = findPath(sr+1, sc, er, ec, dp);

        dp[sr][sc] = right + down;

        return dp[sr][sc];
    }
}