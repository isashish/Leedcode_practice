class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int len = nums.length;

        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int[] diff = new int[len];

        boolean[] seen = new boolean[51];
        int distinct = 0;

        for(int i = 0; i < nums.length; i++){
            if(!seen[nums[i]]){
                seen[nums[i]] = true;
                distinct++;
            }
            prefix[i] = distinct;
        }

        seen = new boolean[51];
        distinct = 0;

        for(int i = len - 1; i >= 0; i--){
            suffix[i] = distinct;

            if(!seen[nums[i]]){
                seen[nums[i]] = true;
                distinct++;
            }
        }

        for(int i = 0; i < len; i++){
            diff[i] = prefix[i] - suffix[i];
        }
        return diff;
    }
}