class Solution {
    public int uniquePathsIII(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean [][] isVisited = new boolean[row][col];
        int sr = 0;
        int sc = 0;
        int walkableCells = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j]==1){
                    sr = i;
                    sc = j;
                }
                if(grid[i][j] != -1){
                    walkableCells += 1;
                }
            }
        }

        int count = findPath(sr, sc, isVisited, grid, walkableCells, 0);
        
        return count;        
    }
    private int findPath(int sr, int sc, boolean[][]isVisited, int[][]grid, int walkableCells, int visitedCount){
        if(sr<0 || sc<0) return 0;
        if(sr>=grid.length || sc>=grid[0].length) return 0;
        if(isVisited[sr][sc]) return 0;
        if(grid[sr][sc] == -1) return 0;
        if(grid[sr][sc] == 2){
           return visitedCount + 1 == walkableCells ? 1 : 0;
        }

        isVisited[sr][sc] = true;

        int right = findPath(sr, sc+1, isVisited, grid, walkableCells, visitedCount + 1);
        int down = findPath(sr+1, sc, isVisited, grid, walkableCells, visitedCount + 1);
        int left = findPath(sr, sc-1, isVisited, grid, walkableCells, visitedCount + 1);
        int up = findPath(sr-1, sc, isVisited, grid, walkableCells, visitedCount + 1);

        isVisited[sr][sc] = false;

        return right + down + left + up;
    }
}