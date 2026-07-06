class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;

        
        Arrays.sort(intervals, (vec1, vec2) -> {
            if(vec1[0] != vec2[0])
                return vec1[0] - vec2[0];
            return vec2[1] - vec1[1];
        });

        int res = 0, r = 0;

        for(int[] x : intervals){
            if(x[1] > r){
                r = x[1];
                res++;
            }
        }
        return res;
    }
}