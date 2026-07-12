class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

            for (int i = 0; i <  grid.length; i++){
                for (int j = 0; j < grid[i].length; j++){
                    if(!vis[i][j] && grid[i][j] == 1){
                        return bfs(grid, i, j, vis);
                    }
                }
            }
            return  1;
    }
    private int bfs(int[][] grid, int row, int col, boolean[][] vis){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        vis[row][col] = true;
        int perimeter = 0;

        int[] dr = {-1, 0, 1, 0}; //Up, Right, Down, Left
        int[] dc = {0, 1, 0, -1};
        while (!queue.isEmpty()){
            int[] point = queue.remove();
            perimeter += 4;
            for(int i = 0; i < 4; i++){
                int newRow = point[0] + dr[i];
                int newCol = point[1] + dc[i];
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1){
                    perimeter--;
                    if(!vis[newRow][newCol]){
                        queue.add(new int[]{newRow, newCol});
                        vis[newRow][newCol] = true;
                    }
                }
            }
        }
        return perimeter;
    }
}