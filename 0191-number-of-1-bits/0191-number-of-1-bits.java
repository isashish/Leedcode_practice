class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0){
            //LSB bit of number
            int last = n & 1;
            if(last == 1){
                count++;
            }
            //right shift the number's bit
            n = n >> 1;
        }
        return count;
    }
}