class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;

        int leftToRight = 1;
        int rightToLeft = 1;

        for(int i = 0; i < n; i++){
            if(leftToRight == 0)
                leftToRight = 1;
            if(rightToLeft == 0)
                rightToLeft = 1;

            leftToRight *= nums[i];

            int j = n - i - 1;
            rightToLeft *= nums[j];

            maxProd = Math.max(leftToRight, Math.max(rightToLeft, maxProd));
        }
        return maxProd;
        
    }
}