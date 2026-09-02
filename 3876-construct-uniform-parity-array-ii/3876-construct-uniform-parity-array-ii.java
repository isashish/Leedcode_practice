class Solution {
    public boolean uniformArray(int[] nums1) {
        int minNum = Integer.MAX_VALUE;
        boolean allEven = true;

        for(int x : nums1){
            minNum = Math.min(minNum, x);

            if(x % 2 != 0){
                allEven = false;
            }
        }
        if(minNum % 2 != 0){
            return true;
        }
        if(allEven){
            return true;
        }
        return false;
    }
}