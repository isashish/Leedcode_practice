class Solution {
    private final int PRIME = 101;

    private long calculateHash(String str){
        long hash = 0;
        for(int i  = 0; i < str.length(); i++){
            hash = (long)(hash + str.charAt(i) * Math.pow(PRIME, i));
        }
        return hash;
    }

    private long updateHash(long prevHash, char oldChar, char newChar, int patternLength){
        long newHash = (prevHash - oldChar)/PRIME;
        newHash = (long)(newHash + newChar * Math.pow(PRIME, patternLength-1));
        return newHash;
    }

    private int search(String text, String pattern){
        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, patternLength));

        for(int i = 0; i <= text.length() - patternLength; i++){
            if(patternHash == textHash){
                if(text.substring(i, i+patternLength).equals(pattern)){
                    return i;
                }
            }
            if(i < text.length() - patternLength){
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i+patternLength), patternLength);
            }
        }
        return -1;
    }


    public int strStr(String haystack, String needle) {
        if(haystack.length() >= needle.length()){
            return this.search(haystack, needle);
        }
        return -1;
        
    }
}