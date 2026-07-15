class Solution {
    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
    public int gcdOfOddEvenSums(int n) {
        int k = 1;
        int sumOdd = 0;
        int sumEven = 0;
        for(int i = 1; i <= n; i++){
            sumEven += 2*i;
            sumOdd += 2*i -1;
        }
        return gcd(sumOdd, sumEven);
    }
}