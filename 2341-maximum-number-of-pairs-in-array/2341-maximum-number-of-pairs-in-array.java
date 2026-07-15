class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        int pair = 0;
        int leftover = 0;
        int[] ans = new int[2];
        for(int freq : map.values()){
            pair += freq / 2;
            leftover += freq % 2;
        }
        return new int[]{pair, leftover};
    }
}