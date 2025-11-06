class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxOnes = 0;
        for(int num : nums){
            if(num == 1){
                count++;
                maxOnes = Math.max(maxOnes, count);
            }
            else{
                count = 0;
            }
        }
        return maxOnes;
        
    }
}