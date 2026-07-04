class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] != 0) {
            return false;
        }

        int row = 0;
        int col = 0;

        int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int move = 1; move < n * n; move++) {
            boolean found = false;

            for (int k = 0; k < 8; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
                    grid[nr][nc] == move) {
                    row = nr;
                    col = nc;
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}