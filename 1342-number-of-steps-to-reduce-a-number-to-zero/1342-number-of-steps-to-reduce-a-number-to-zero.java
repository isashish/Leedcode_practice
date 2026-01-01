class Solution {
    public int numberOfSteps(int num) {
        return reduceToZero(num, 0);
    }
    public static int reduceToZero(int n, int cnt){
        if(n == 0){
            return cnt;
        }
        else if(n%2 == 0){
            return reduceToZero(n/2, cnt+1);
        }
        return reduceToZero(n-1, cnt+1);
    }
}