class Solution {
    public int minBitFlips(int start, int goal) {
        int bit_flip = 0;
        while(start != 0 || goal != 0){
            int s_bit = start&1;
            int g_bit = goal&1;

            //check current last bits are different
            if(s_bit != g_bit){
                bit_flip += 1;
            }
            start >>= 1;
            goal >>=  1;
        }
        return bit_flip;
        
    }
}