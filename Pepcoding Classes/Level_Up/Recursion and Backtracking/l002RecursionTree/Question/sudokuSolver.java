class Solution {

    public boolean isSafeToPlaceNumer(char[][] board, int row, int col, int num) {
        int n = board.length, m = board[0].length;

        // row
        for (int j = 0; j < m; j++) {
            if ((board[row][j] - '0') == num)
                return false;
        }

        // col
        for (int i = 0; i < n; i++) {
            if ((board[i][col] - '0') == num)
                return false;
        }

        // matrix
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((board[r + i][c + j] - '0') == num)
                    return false;
            }
        }

        return true;
    }

    public boolean solveSudoku(char[][] board, int idx) {
        if (idx == 81)
            return true;

        int r = idx / 9;
        int c = idx % 9;
        if (board[r][c] != '.') {
            if (solveSudoku(board, idx + 1))
                return true;
        } else {
            for (int num = 1; num <= 9; num++) {
                if (isSafeToPlaceNumer(board, r, c, num)) {
                    board[r][c] = (char) (num + '0');
                    if (solveSudoku(board, idx + 1))
                        return true;
                    board[r][c] = '.';
                }
            }
        }

        return false;
    }

    // Optimized
    public boolean solveSudoku02(char[][] board, int idx, ArrayList<Integer> IDX) {
        if (idx == IDX.size())
            return true;

        int r = IDX.get(idx) / 9;
        int c = IDX.get(idx) % 9;

        for (int num = 1; num <= 9; num++) {
            if (isSafeToPlaceNumer(board, r, c, num)) {
                board[r][c] = (char) (num + '0');
                if (solveSudoku02(board, idx + 1, IDX))
                    return true;
                board[r][c] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        ArrayList<Integer> IDX = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    IDX.add(i * 9 + j);
            }
        }
        // solveSudoku(board, 0);
        solveSudoku02(board, 0, IDX);
    }
}