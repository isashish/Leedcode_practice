class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;

        for (int d = 0; d < m + n - 1; d++) {
            // Temporary list to store the current diagonal
            List<Integer> diagonal = new ArrayList<>();

            // Figure out the starting row (must be within matrix)
            int rowStart = Math.max(0, d - (n - 1));
            // Ending row (must not go beyond matrix rows)
            int rowEnd = Math.min(d, m - 1);

            for (int i = rowStart; i <= rowEnd; i++) {
                int j = d - i;
                diagonal.add(mat[i][j]);
            }

            // If diagonal is even, reverse before adding
            if (d % 2 == 0) {
                Collections.reverse(diagonal);
            }

            for (int num : diagonal) {
                result[index++] = num;
            }
        }

        return result;
    }
}
