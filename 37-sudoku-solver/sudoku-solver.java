class Solution {
    private final int[] rows = new int[9];
    private final int[] cols = new int[9];
    private final int[] boxes = new int[9];

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    int mask = 1 << num;
                    rows[r] |= mask;
                    cols[c] |= mask;
                    boxes[(r / 3) * 3 + c / 3] |= mask;
                }
            }
        }

        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    int box = (r / 3) * 3 + c / 3;

                    for (int num = 0; num < 9; num++) {
                        int mask = 1 << num;

                        if ((rows[r] & mask) == 0 &&
                            (cols[c] & mask) == 0 &&
                            (boxes[box] & mask) == 0) {

                            board[r][c] = (char) ('1' + num);
                            rows[r] |= mask;
                            cols[c] |= mask;
                            boxes[box] |= mask;

                            if (solve(board)) {
                                return true;
                            }

                            board[r][c] = '.';
                            rows[r] ^= mask;
                            cols[c] ^= mask;
                            boxes[box] ^= mask;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }
}