class Solution {
    public boolean isValid(String word) {
        //At least one vowel, At least one Consonant
        String regex = "^(?=.*[AEIOUaeiou])(?=.*[B-DF-HJ-NP-TV-Zb-df-hj-np-tv-z])[A-Za-z0-9]{3,}$";
        return word.matches(regex);
    }
}