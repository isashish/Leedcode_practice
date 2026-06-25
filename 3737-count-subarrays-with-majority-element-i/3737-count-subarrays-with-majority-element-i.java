class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int currSum = 0;

        mp.put(0, 1); // we have seen cumSum = 0 in the begining once
        int validLeftPoints = 0;
        int result = 0;

        for(int x : nums){
            if(x == target){
                validLeftPoints += mp.getOrDefault(currSum, 0);
                currSum++;
            } else{
                currSum--;
                validLeftPoints -= mp.getOrDefault(currSum, 0);
            }
            mp.merge(currSum, 1, Integer::sum);
            result += validLeftPoints;
        }
        return result;
    }
}