class Solution {
    private class TrieNode{
        TrieNode[] child;
        boolean endOfWord;
        String word;
        public TrieNode(){
            child = new TrieNode[26]; // a -> z
            for(int i = 0; i < 26; i++){
                child[i] =  null;
            }
            endOfWord = false;
            this.word = "";
        }
        public TrieNode(TrieNode[] child, boolean endOfWord){
            this.child = child;
            this.endOfWord = endOfWord;
        }
    }
    TrieNode root = new TrieNode();

    //Insertion in Trie
    public void insertWord(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] =  new TrieNode();
            }
            if(i == word.length()-1){
                curr.child[idx].endOfWord = true;
                curr.child[idx].word = word;
            }
            curr = curr.child[idx];
        }
    }

    public String searchWord(String key){
        TrieNode curr =  root;
        for (int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';

            if(curr.child[idx] == null){
                return key;
            }
            if(curr.child[idx].endOfWord){
                return curr.child[idx].word;
            }
            curr = curr.child[idx];
        }
        return key;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for(String word : dictionary){
            insertWord(word);
        }
        String[] words = sentence.trim().split("\\s+");

        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            ans.append(searchWord(word)).append(" ");
        }
        return ans.toString().trim();
    }
}