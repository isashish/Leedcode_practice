class Solution {
    private int findWavinessScore(String s){
        int score = 0;
        for(int i = 1; i <= s.length()-2; i++){
            int mid = s.charAt(i) - '0';
            int left = s.charAt(i-1) - '0';
            int right = s.charAt(i+1) - '0';

            //peaks
            if(mid > left && mid > right){
                score++;
            }
            if(mid < left && mid < right){
                score++;
            }
        }
        return score;
    }
    public int totalWaviness(int num1, int num2) {
        int wavinessScore = 0;
        for(int num = num1; num <= num2; num++){
            String s = String.valueOf(num);
            wavinessScore += findWavinessScore(s);
        }
        return wavinessScore; 
    }
}