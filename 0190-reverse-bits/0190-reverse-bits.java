class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            int bit = n & 1; // Extract the least significant bit
            result = (result << 1) | bit; // Append the curr bit to the result
            n = n >>> 1;
        }
        return result;
        
    }
}