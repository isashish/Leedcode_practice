class Trie {
    private class TrieNode{
        TrieNode[] child;
        boolean isEndOfWord;

        public TrieNode() {
            child = new TrieNode[26];
            for(int i = 0; i < 26; i++){
                child[i] = null;
            }
            isEndOfWord = false;
        }
    }
    TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
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
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null){
                return false;
            }
            if(i == word.length()-1 && curr.child[idx].isEndOfWord != true){
                return false;
            }
            curr = curr.child[idx];
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.child[idx] == null){
                return false;
            }
            if(i == prefix.length()-1 && curr.child[idx].isEndOfWord != true){
                return true;
            }
            curr = curr.child[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */