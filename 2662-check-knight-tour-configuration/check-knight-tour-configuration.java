class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;

        int[][] position = new int[n * n][2];

        // Store the position of every move number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                position[grid[i][j]][0] = i;
                position[grid[i][j]][1] = j;
            }
        }

        // Knight tour must start from (0, 0)
        if (position[0][0] != 0 || position[0][1] != 0) {
            return false;
        }

        // Check every consecutive move
        for (int i = 1; i < n * n; i++) {
            int x1 = position[i - 1][0];
            int y1 = position[i - 1][1];
            int x2 = position[i][0];
            int y2 = position[i][1];

            int dx = Math.abs(x1 - x2);
            int dy = Math.abs(y1 - y2);

            if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) {
                return false;
            }
        }

        return true;
    }
}