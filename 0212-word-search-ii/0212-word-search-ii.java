class Solution {
    private class TrieNode{
        TrieNode[] child;
        boolean endOfWord;
        String word;
        public TrieNode(){
            this.child = new TrieNode[26];
            for(int i = 0; i < 26; i++){
                child[i] = null;
            }
            this.endOfWord = false;
            this.word = "";
        }
    }
    TrieNode root = new TrieNode();

    private void insertWord(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new TrieNode();
            }
            if(i == word.length()-1){
                curr.child[idx].endOfWord = true;
                curr.child[idx].word = word;
            }
            curr = curr.child[idx];
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            this.insertWord(word);
        }

        List<String> wordList = new ArrayList<>();
        int row = board.length;
        int col = board[0].length;

        boolean[][] isVisited = new boolean[row][col];

        for(int i = 0;  i < row; i++){
            for(int j = 0; j < col; j++){
                int idx = board[i][j] - 'a';
                if(this.root.child[idx] != null){
                    wordFind(i, j, board, isVisited, this.root, wordList);
                }
            }
        }
        return wordList;
    }

    private void wordFind(int sr, int sc, char[][] board, boolean[][] isVisited, TrieNode node, List<String> ansList){
        if(sr<0 || sc<0){
            return;
        }
        if(sr >= board.length || sc >= board[0].length){
            return;
        }
        if(isVisited[sr][sc]){
            return;
        }

        int idx = board[sr][sc] - 'a';

        TrieNode nextNode = node.child[idx];
        if(node.child[idx] == null){
            return;
        }

        isVisited[sr][sc] = true;
        if(nextNode.endOfWord == true){
            ansList.add(nextNode.word);
            nextNode.endOfWord = false;
        }

        wordFind(sr, sc+1, board, isVisited, nextNode, ansList);
        wordFind(sr+1, sc, board, isVisited, nextNode, ansList);
        wordFind(sr, sc-1, board, isVisited, nextNode, ansList);
        wordFind(sr-1, sc, board, isVisited, nextNode, ansList);

        isVisited[sr][sc] = false;
    }
}