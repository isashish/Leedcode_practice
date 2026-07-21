class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)){
            return 0;
        }
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int length = 0;

        while(!q.isEmpty()){
            int size = q.size();
            length++;

            for(int i = 0; i < size; i++){
                String current = q.poll();

                for(int j = 0; j < current.length(); j++){
                    char[] temp = current.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        temp[j] =  ch;
                        String newWord = new String(temp);
                        if(newWord.equals(endWord)){
                            return length + 1;
                        }
                        if(words.contains(newWord)){
                            q.offer(newWord);
                            words.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}