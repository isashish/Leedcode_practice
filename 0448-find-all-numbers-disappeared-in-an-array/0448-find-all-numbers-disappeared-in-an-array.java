import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        // Add all numbers from the array to the set
        for(int num : nums){
            set.add(num);
        }

        // Now check which numbers from 1 to n are missing
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
        
    }
}