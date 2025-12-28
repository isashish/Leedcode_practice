class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int s = 0; 
        int e = numbers.length - 1;
        int[] arr = new int[2];
        while(s < e){
            int sum = numbers[s] + numbers[e];
            if(sum == target){
                arr[0] = s+1; //1-indexed array start from index 1 instead of 0
                arr[1] = e+1;
                return arr;
            }
            else if(sum < target){
                s++;
            }
            else{
                e--;
            }
        }
        return arr;
    }
}