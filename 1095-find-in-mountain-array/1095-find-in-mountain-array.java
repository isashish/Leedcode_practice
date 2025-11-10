/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Step 1: find peak index
        int peak = peakIndexInMountainArray(mountainArr, n);

        // Step 2: binary search in ascending part
        int firstTry = orderAgnosticBS(mountainArr, target, 0, peak, true);
        if (firstTry != -1) {
            return firstTry;
        }

        // Step 3: binary search in descending part
        return orderAgnosticBS(mountainArr, target, peak + 1, n - 1, false);
    }

    static int peakIndexInMountainArray(MountainArray arr, int n) {
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int midVal = arr.get(mid);
            int midNext = arr.get(mid + 1);  // safe because mid < end

            if (midVal > midNext) {
                // you're in descending part
                end = mid;
            } else {
                // ascending part
                start = mid + 1;
            }
        }
        return start; // start == end → peak index
    }

    static int orderAgnosticBS(MountainArray arr, int target, int start, int end, boolean isAsc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = arr.get(mid);

            if (midVal == target) {
                return mid;
            }

            if (isAsc) {
                if (target < midVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target < midVal) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
