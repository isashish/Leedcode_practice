class Solution {
    public int smallestNumber(int n, int t) {
        int original = n;
        int product = 1;
        while(n != 0){
            int digit = n%10;
            product *= digit;
            n /= 10;
        }
        if(product % t == 0){
            return original;
        }
        return smallestNumber(original+1, t);
    }
}