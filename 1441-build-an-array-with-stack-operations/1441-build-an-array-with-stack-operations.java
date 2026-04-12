class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();

        int  i = 0; // pointer for target
        for(int num = 1; num <= n; num++){
            if(i == target.length) break;

            result.add("Push");

            if(num == target[i]){
                i++; //move target pointer
            }
            else {
                result.add("Pop");
            }
        }
        return result;
    }
}