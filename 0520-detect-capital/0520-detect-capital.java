class Solution {
    public boolean detectCapitalUse(String word) {
        String regex = "^([A-Z]+|[a-z]+|[A-Z][a-z]+)$";
        return word.matches(regex);
    }
}