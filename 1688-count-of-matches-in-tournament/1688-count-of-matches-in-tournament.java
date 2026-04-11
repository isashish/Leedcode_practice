class Solution {
    public int numberOfMatches(int n) {

        // In 1 match -> When 2 teams will play -> 1 will be winner | 1 will eliminated 
        // When n teams will play -> 1 will be winner | n-1 will eliminated  => then total n-1 matches
        return n-1;  
    }
}