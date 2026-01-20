class Solution {
    public int minFlips(int a, int b, int c) {
        int flipsCount = 0;

        while(a > 0 || b > 0 || c > 0){
            int bit_a = a & 1;
            int bit_b = b & 1;
            int bit_c = c & 1;

            if(bit_c == 0){
                //To get a 0 from an OR operation both a and b must be 0
                flipsCount += (bit_a + bit_b);
            }
            else{
                //To get a 1 from an OR operation at least one of a or b must be 1
                if(bit_a == 0 && bit_b == 0){
                    flipsCount += 1;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flipsCount;
    }
}