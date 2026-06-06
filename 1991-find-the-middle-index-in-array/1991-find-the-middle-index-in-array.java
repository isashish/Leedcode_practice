class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            int leftSum = curr;
            curr += nums[i];
            int rightSum = sum - curr;
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }
}