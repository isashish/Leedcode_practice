class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        for(int d=1;d<n;d++)
        {
            int i=0,j=d;
            PriorityQueue<Integer> pq =  new PriorityQueue<>((a,b)->(a-b));
            int dummyi = i, dummyj = j;
            while(i<n && j<n)
            {
                pq.offer(grid[i][j]);
                i++;
                j++;
            }
            while(dummyi<n && dummyj<n)
            {
                grid[dummyi][dummyj] = pq.poll();
                dummyi++;
                dummyj++;
            }
        }

        for(int d=0;d<n;d++)
        {
            int i=d,j=0;
            PriorityQueue<Integer> pq =  new PriorityQueue<>((a,b)->(b-a));
            int dummyi = i, dummyj = j;
            while(i<n && j<n)
            {
                pq.offer(grid[i][j]);
                i++;
                j++;
            }
            while(dummyi<n && dummyj<n)
            {
                grid[dummyi][dummyj] = pq.poll();
                dummyi++;
                dummyj++;
            }
        }
        return grid;
    }
}