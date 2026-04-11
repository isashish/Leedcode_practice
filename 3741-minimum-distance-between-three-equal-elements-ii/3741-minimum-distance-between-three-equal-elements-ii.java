class Solution {
    public int minimumDistance(int[] nums) {
        //target elementws having greater then three frequencey

        int n = nums.length;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        int result = n;

        for(int k = 0; k < n; k++){
            mp.putIfAbsent(nums[k], new ArrayList<>());//If nums[k] is not already present in the map mp then create a new empty ArrayList and insert it. If it is already present → do nothing.

            mp.get(nums[k]).add(k);  //store the index of nums

            if(mp.get(nums[k]).size() >= 3){
                List<Integer> list = mp.get(nums[k]); //make a list of key num
                int siz = list.size();
                int i = list.get(siz - 3);
                result = Math.min(result, k - i);
            }
        }
        return result >= n ? -1 : 2*result;
    }
}