class Solution {
    public int missingNumber(int[] nums) {
        int ans = cyclicSort(nums);
        return ans;
    }
    public int cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correctIdx = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correctIdx]){
                swap(arr, i, correctIdx);
            } 
            else{
                i++;
            }
        }
        // Search for first missing number
        for(int idx  = 0; idx < arr.length; idx++){
            if(arr[idx] != idx){
                return idx;
            }
        }
        return arr.length;
    }
    void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}