class Solution {
    public int countCharacters(String[] words, String chars) {

        int[] charCount = new int[26];

        for(char ch : chars.toCharArray()){
            //character count store in array
            charCount[ch - 'a']++;
        }

        int result = 0;

        for(String word : words){
            int[] wordCount = new int[26];
            for(char ch : word.toCharArray()){
                //words char count store in array
                wordCount[ch - 'a']++;
            }

            boolean ok = true;
            for(int i = 0; i < 26; i++){
                //if wordcount contain extra char
                if(wordCount[i] > charCount[i]){
                    ok = false;
                    break;
                }
            }

            //if true then add the word length
            if(ok){
                result += word.length();
            }
        }
        return result;
        
    }
}