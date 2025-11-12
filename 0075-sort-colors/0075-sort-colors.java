class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int mid = 0;
        int hi = n-1;

        while(mid <= hi){
            if(nums[mid] == 0){
                swap(nums, lo, mid);
                lo++;
                mid++;
            } else if(nums[mid] == 1){
                mid++;
            } else{
                //nums[mid] == 2
                swap(nums, mid, hi);
                hi--;
            }
        }
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}