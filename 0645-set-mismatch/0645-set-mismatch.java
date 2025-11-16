class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n+1];
        int dup = -1, miss = -1;

        // Count occurrences of each number
        for(int num : nums){
            freq[num]++;
        }

        for(int i = 0; i <= n; i++){
            if(freq[i] == 2){
                dup = i;
            } 
            if(freq[i] == 0){
                miss = i;
            }
        }
        return new int[]{dup, miss};
    }
}