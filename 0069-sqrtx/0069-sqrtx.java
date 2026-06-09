class Solution {
    public int mySqrt(int x) {
        int result = 0;

//      start from heigest possible bit
        for(int bit = 15; bit >= 0; bit--){
            int candidate = result | (1 << bit);

            if((long) candidate * candidate <= x){
                result = candidate;
            }
        }
        return result;
    }
}