class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        long cnt = 0; long smallest = Long.MAX_VALUE; 
        long sum = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j]<0){
                    cnt++;
                }
                int val = Math.abs(matrix[i][j]);
                smallest = Math.min(smallest, val);
                sum += val;
               
            }
        }
        if(cnt%2==0) return sum;
        return sum - 2*smallest;
    }
}