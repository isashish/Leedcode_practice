class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int mid = n/2;

        double minMid = Double.MAX_VALUE;

        int i = 0;
        while(i != mid){
            minMid = Math.min(minMid, (nums[i]+nums[n-i-1]));
            i++;
        }
        return minMid/2;
    }
}