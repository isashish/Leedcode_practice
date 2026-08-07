class Solution {
    private class TrieNode{
       TrieNode[] child;
       boolean isEndOfWord;
       public TrieNode(){
           this.child = new TrieNode[26];
           for(int i = 0; i < 26; i++){
               child[i] = null;
           }
           this.isEndOfWord = false;
       }
    }
    TrieNode root = new TrieNode();

    private void wordInsert(String word){
        TrieNode curr = this.root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new TrieNode();
            }
            if(i == word.length()-1){
                curr.child[idx].isEndOfWord = true;
            }
            curr = curr.child[idx];
        }
    }
    private boolean wordSearch(String word){
        Boolean[] dp = new Boolean[word.length() + 1];
        return wordBreakHelper(word, 0, dp);
    }

    private boolean wordBreakHelper(String word, int start, Boolean[] dp){

        if(start == word.length()){
            return true;
        }
        if(dp[start] != null){
            return dp[start];
        }

        TrieNode curr = this.root;

        for(int i = start; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';

            if(curr.child[idx] == null){
                break;
            }
            curr = curr.child[idx];
            if(curr.isEndOfWord){
                // Option 1: Break the word here
                if(wordBreakHelper(word, i+1, dp)){
                    return dp[start] = true;
                }
            }

        }
        return dp[start] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict){
            this.wordInsert(word);
        }
        return wordSearch(s); 
    }
}