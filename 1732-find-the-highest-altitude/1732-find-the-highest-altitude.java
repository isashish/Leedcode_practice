class Solution {
    public int largestAltitude(int[] gain) {
        int altitute = 0;
        int maxAltitute = 0;
        for(int g : gain){
            altitute += g;
            maxAltitute = Math.max(altitute, maxAltitute);
        }
        return maxAltitute;
        
    }
}