class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxSum = Integer.MIN_VALUE;
        //person = row
        //account = col
        for(int row = 0; row < accounts.length; row++){
            int rowSum = 0;
            for(int col = 0; col < accounts[row].length; col++){
                rowSum += accounts[row][col];
            }
            if(rowSum > maxSum){
                maxSum = rowSum;
            }
        }
        return maxSum;
        
    }
}