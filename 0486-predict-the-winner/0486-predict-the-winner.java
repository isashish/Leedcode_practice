class Solution {
    public boolean predictTheWinner(int[] nums) {
        int playerMaxAdv = currPlayerAdv(nums, 0, nums.length-1);
        return playerMaxAdv >= 0; 
    }
    private int currPlayerAdv(int[] nums, int left, int right){
        //base case
        if(left == right) return nums[left];

        int chooseLeft = nums[left] - currPlayerAdv(nums, left+1, right);

        int chooseRight = nums[right] - currPlayerAdv(nums, left, right-1);

        return Math.max(chooseLeft, chooseRight);
    }
}