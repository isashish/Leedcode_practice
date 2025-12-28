class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int last = s.length() - 1;

        while(start < last){
            char currentFirst = s.charAt(start);
            char currentLast = s.charAt(last);

            if(!Character.isLetterOrDigit(currentFirst)){
                start++;
            }
            else if(!Character.isLetterOrDigit(currentLast)){
                last--;
            }
            else{
                if(Character.toLowerCase(currentFirst)!=Character.toLowerCase(currentLast)){
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}