class Solution {
    public int[] leftRightDifference(int[] nums) {

        //overal sum
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        int curr = 0; //CummulativeSum
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int leftSum = curr;
            curr += nums[i];
            int rightSum = sum - curr;
            ans[i] = Math.abs(rightSum - leftSum);
        }
        return ans;
    }
}