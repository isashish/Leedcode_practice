class Solution {
    public int subtractProductAndSum(int n) {
        int ans = differenceOfProdAndSum(n);
        return ans;
    }
    static int differenceOfProdAndSum(int num){
        int prod = 1;
        int sum = 0;

        while(num > 0){
            int digit = num % 10;
            sum += digit;
            prod *= digit;
            num = num/10;
        }
        return prod - sum;
    }
}