class Solution {
    private int calMinFinishTime(int[] firstRS, int[] firstRD, int[] secondRS, int[] secondRD){
        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < firstRS.length; i++){
            mini = Math.min(mini, firstRS[i]+firstRD[i]);
        }

        int result = Integer.MAX_VALUE;

        for(int i = 0; i < secondRS.length; i++){
            result = Math.min(result, Math.max(mini, secondRS[i]) + secondRD[i]);
        }
        return result;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
            calMinFinishTime(landStartTime, landDuration, waterStartTime, waterDuration),
            calMinFinishTime(waterStartTime, waterDuration, landStartTime, landDuration)
        );
        
    }
}