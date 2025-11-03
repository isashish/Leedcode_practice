class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currMinSum = 0, currMaxSum = 0;
        int minSum = nums[0], maxSum = nums[0];

        for(int i = 0; i < nums.length; i++){
            //Maximum sum subarray
            currMaxSum = Math.max(currMaxSum+nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMaxSum);

            //Minimum sum subarray
            currMinSum = Math.min(currMinSum+nums[i], nums[i]);
            minSum = Math.min(minSum, currMinSum);

            //Sum of all the elements of array
            totalSum += nums[i];
        }
        int normalSum = maxSum;
        int circularSum = totalSum - minSum;
        if(totalSum == minSum){
            return normalSum;
        }
        return Math.max(normalSum, circularSum);
        
    }
}