import java.util.*;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        Set<String> guardSet = new HashSet<>();
        Set<String> wallSet = new HashSet<>();
        Set<String> guarded = new HashSet<>();

        for (int[] g : guards){
            guardSet.add(g[0] + "," + g[1]);
        }

        for (int[] w : walls){
            wallSet.add(w[0] + "," + w[1]);
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int[] g : guards){
            int r = g[0];
            int c = g[1];

            for (int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                while (nr >= 0 && nr < m && nc >= 0 && nc < n){
                    String pos = nr + "," + nc;

                    if(wallSet.contains(pos) || guardSet.contains(pos)){
                        break;
                    }
                    guarded.add(pos);
                    nr += dir[0];
                    nc += dir[1];
                }
            }
        }

        int totalCells = m * n;
        int occupied = guardSet.size() + wallSet.size();
        int unguarded = totalCells - occupied -guarded.size();

        return unguarded;
        
    }
}