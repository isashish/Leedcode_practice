class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>(nums.length);
        int cur = 0;

        for(int bit : nums){
            cur = ((cur << 1) + bit) % 5;
            //cur << 1 means shift left by 1 bit, which is same as multiplying by 2.
            //cur = (cur * 2 + bit)
            res.add(cur == 0);
        }
        return res;
        
    }
}