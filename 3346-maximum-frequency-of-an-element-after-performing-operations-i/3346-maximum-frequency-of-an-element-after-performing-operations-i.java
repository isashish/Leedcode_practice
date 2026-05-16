class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxVal = Arrays.stream(nums).max().getAsInt() + k;
        int[] diff = new int[maxVal + 2];
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            int l = Math.max(num - k, 0);
            int r = Math.min(num + k, maxVal);

            diff[l]++;
            diff[r + 1]--;
        }

        int result = 1;

        for(int target = 0; target <= maxVal; target++){
            if(target > 0) diff[target] += diff[target - 1];

            int targetFreq = freq.getOrDefault(target, 0);
            int needConversion = diff[target] - targetFreq;

            int maxPossibleFreq = Math.min(needConversion, numOperations);
            result = Math.max(result, targetFreq + maxPossibleFreq);
        }
        return result;
        
    }
}