class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 0, count = 1;

        for(int i = 1; i < prices.length; i++){
            if(prices[i-1] - prices[i] == 1){
                count++;
            } else{
                res += ((count*(count+1))/2);
                count=1;
            }
        }
        res += (count*(count+1))/2;
        return res;
    }
}