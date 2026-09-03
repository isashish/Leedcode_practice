class Solution {
    public boolean uniformArray(int[] nums1) {
        int minValue = Integer.MAX_VALUE;
        boolean AllEven = true;
        for(int x : nums1){
            minValue = Math.min(x, minValue);
            if(x % 2 != 0){
                AllEven = false;
            }
        }
        if(minValue % 2 != 0){
            return true;
        }
        if(AllEven){
            return true;
        }
        return false;
    }
}