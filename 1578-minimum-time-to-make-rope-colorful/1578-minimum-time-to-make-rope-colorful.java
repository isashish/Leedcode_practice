class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int minTime = 0;

        for(int i = 1; i < n; i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                //Add smaller time
                minTime += Math.min(neededTime[i], neededTime[i-1]);
                //Current ballon time to max time
                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]);
            }
        }
        return minTime;
    }
}