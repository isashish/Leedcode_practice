class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;

        // Finding pivote element
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        // Finding of greater then pivote 
        if(i >= 0){
            int j = n-1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i+1, n-1);
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}