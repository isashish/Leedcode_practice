class Solution {
    public int countHillValley(int[] nums) {
        int hills = 0;
        int valley = 0;

        int left = 0;
        for(int i = 1; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            if(nums[i] > nums[left] && nums[i] > nums[i+1]){
                hills++;
                left = i;
            }
            if(nums[i] < nums[left] && nums[i] < nums[i+1]){
                valley++;
                left = i;
            }
        }
        return hills + valley;
    }
}