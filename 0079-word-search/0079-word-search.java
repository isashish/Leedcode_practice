class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] isVisited = new boolean[row][col];

        int sr = 0;
        int sc = 0;

        for(int i = 0;  i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == word.charAt(0)){
                    if(wordFind(i, j, board, isVisited, word, 0)){
                        return true;
                    }

                }
            }
        }
        return false;
    }
   private boolean wordFind(int sr, int sc, char[][] board, boolean[][] isVisited, String word, int i){

        if(sr<0 || sc<0){
            return false;
        }
        if(sr >= board.length || sc >= board[0].length){
            return false;
        }
        if(isVisited[sr][sc]){
            return false;
        }
        if(board[sr][sc] != word.charAt(i)){
            return false;
        }

        // if char at index i match then move
        isVisited[sr][sc] = true;

        //i length is equal to word length
        if(i == word.length()-1){
            isVisited[sr][sc] = false;
            return true;
        }

        //right
        boolean right = wordFind(sr, sc+1, board, isVisited, word, i+1);
        //down
        boolean down = wordFind(sr+1, sc, board, isVisited, word, i+1);
        //left
        boolean left = wordFind(sr, sc-1, board, isVisited, word, i+1);
        //up
        boolean up = wordFind(sr-1, sc, board, isVisited, word, i+1);

        isVisited[sr][sc] = false;

        return right || down || left || up;
    }
}