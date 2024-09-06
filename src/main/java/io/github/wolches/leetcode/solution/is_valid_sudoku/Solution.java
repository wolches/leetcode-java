package io.github.wolches.leetcode.solution.is_valid_sudoku;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isValidPlacement(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidPlacement(char[][] board, int row, int col) {
        // Check if num is already in the same row, column or 3x3 subgrid
        for (int i = 0; i < board.length; i++) {
            // Check row
            if (i != row && board[i][col] == board[row][col]) {
                return false;
            }

            // Check column
            if (i != col && board[row][i] == board[row][col]) {
                return false;
            }

            // Check 3x3 subgrid
            int subSquareRow = 3 * (row / 3) + i / 3; // Calculate row index of subgrid
            int subSquareCol = 3 * (col / 3) + i % 3; // Calculate column index of subgrid

            if (subSquareRow != row && subSquareCol != col &&
                board[subSquareRow][subSquareCol] == board[row][col]) {
                return false;
            }
        }

        // Placement is valid
        return true;
    }
}