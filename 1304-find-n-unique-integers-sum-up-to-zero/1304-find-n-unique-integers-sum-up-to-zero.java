class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int low = 0; int high = n-1;
        int num = 1;

        while(low < high){
            arr[low] = num;
            arr[high] = -num;
            low++; high--; num++;
        }
        return arr;
    }
}