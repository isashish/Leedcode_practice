class Solution {
    public int findClosest(int x, int y, int z) {
        int result = 0;
        if(x != y){
            int x_steps = Math.abs(z - x);
            int y_steps = Math.abs(z - y);

            if(x_steps < y_steps){
                result = 1;
            } else if(x_steps > y_steps){
                result = 2;
            }
        }
        return result;
        
    }
}