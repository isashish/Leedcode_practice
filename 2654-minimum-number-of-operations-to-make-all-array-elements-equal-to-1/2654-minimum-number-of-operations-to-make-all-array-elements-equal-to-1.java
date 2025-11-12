class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int num1 = 0;
        int g = 0;
        //Calculate how many 1's are present in array and overall GCD
        for (int x : nums){
            if (x == 1){
                num1++;
            }
            g = gcd(g, x);
        }
        //If there are already some 1s in the array then each elements we can made 1 using one operation with an existing 1
        if (num1 > 0){
            return n - num1;
        }
        if( g > 1){
            //it means all numbers share a common factor greater than 1 so we can never make the GCD = 1
            return -1;
        }

        //Now we finding smallest subarray whose GCD becomes 1
        int minLen = n;
        for(int i = 0; i < n; i++){
            int currentGcd = 0;
            for(int j = i; j < n; j++){
                currentGcd = gcd(currentGcd, nums[j]);
                if(currentGcd == 1){
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen + n - 2;
    }
    private int gcd(int a, int b){ 
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}