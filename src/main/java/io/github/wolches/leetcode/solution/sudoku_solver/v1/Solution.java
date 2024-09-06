package io.github.wolches.leetcode.solution.sudoku_solver.v1;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public void solveSudoku(char[][] board) {
        // To the data structure with restricted and possible values
        Field[][] fieldBoard = toField(board);
        int counter = count(fieldBoard);

        // Fill most of the board by rules without predictions
        while (counter < 81) {
            findRestrictedHorizontal(fieldBoard);
            findRestrictedVertical(fieldBoard);
            findRestrictedSubSquares(fieldBoard);
            trySet(fieldBoard);
            int newCounter = count(fieldBoard);
            if (newCounter == counter) {
                break;
            } else {
                counter = newCounter;
            }
        }

        // Then do some backtracking with acknowledged restrictions
        solve(fieldBoard, 0, 0);

        // Fill the result
        toResult(fieldBoard, board);
    }

    private void findRestrictedHorizontal(Field[][] fields) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j].value != '.') {
                    for (int k = 0; k < fields[i].length; k++) {
                        fields[i][k].restricted.add(fields[i][j].value);
                    }
                }
            }
        }
    }

    private void findRestrictedVertical(Field[][] fields) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j].value != '.') {
                    for (int k = 0; k < fields[i].length; k++) {
                        fields[k][j].restricted.add(fields[i][j].value);
                    }
                }
            }
        }
    }


    private void findRestrictedSubSquares(Field[][] fielda) {
        findRestrictedSubSquare(fielda, 0, 0);
        findRestrictedSubSquare(fielda, 0, 3);
        findRestrictedSubSquare(fielda, 0, 6);
        findRestrictedSubSquare(fielda, 3, 0);
        findRestrictedSubSquare(fielda, 3, 3);
        findRestrictedSubSquare(fielda, 3, 6);
        findRestrictedSubSquare(fielda, 6, 0);
        findRestrictedSubSquare(fielda, 6, 3);
        findRestrictedSubSquare(fielda, 6, 6);
    }

    private void findRestrictedSubSquare(Field[][] fields, int fromH, int fromV) {
        for (int i = fromV; i < fromV + 3; i++) {
            for (int j = fromH; j < fromH + 3; j++) {
                if (fields[i][j].value != '.') {
                    for (int ii = fromV; ii < fromV + 3; ii++) {
                        for (int jj = fromH; jj < fromH + 3; jj++) {
                            fields[ii][jj].restricted.add(fields[i][j].value);
                        }
                    }
                }
            }
        }
    }

    private Field[][] toField(char[][] board) {
        Field[][] fieldBoard = new Field[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                fieldBoard[i][j] = new Field();
                fieldBoard[i][j].value = board[i][j];
            }
        }
        return fieldBoard;
    }

    private int count(Field[][] board) {
        int counter = 0;
        for (Field[] row : board) {
            for (Field field : row) {
                if (field.value != '.') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private void trySet(Field[][] board) {
        for (Field[] row : board) {
            for (Field field : row) {
                field.trySet();
            }
        }
    }

    private char[][] toResult(Field[][] board, char[][] result) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result[i][j] = board[i][j].value;
            }
        }
        return result;
    }

    private boolean solve(Field[][] board, int row, int col) {
        // Base case: If row is equal to board length, entire board has been filled
        if (row == board.length) {
            return true;
        }

        // Move to next row when current row is fully filled
        if (col == board[0].length) {
            return solve(board, row + 1, 0);
        }

        // Skip cells that are already filled
        if (board[row][col].value != '.') {
            return solve(board, row, col + 1);
        }

        // Try different numbers in current cell
        for (Character num : board[row][col].candidates) {
            if (isValidPlacement(board, row, col, num)) {
                board[row][col].value = num; // Fill current cell with valid number

                // Move to next cell
                if (solve(board, row, col + 1)) {
                    return true;
                }

                // Backtrack to previous state if solution not found
                board[row][col].value = '.';
            }
        }

        // No valid solution found
        return false;
    }

    private boolean isValidPlacement(Field[][] board, int row, int col, char num) {
        // Check if num is already in the same row, column or 3x3 subgrid
        for (int i = 0; i < board.length; i++) {
            // Check row
            if (board[i][col].value == num) {
                return false;
            }

            // Check column
            if (board[row][i].value == num) {
                return false;
            }

            // Check 3x3 subgrid
            int subSquareRow = 3 * (row / 3) + i / 3; // Calculate row index of subgrid
            int subSquareCol = 3 * (col / 3) + i % 3; // Calculate column index of subgrid

            if (board[subSquareRow][subSquareCol].value == num) {
                return false;
            }
        }

        // Placement is valid
        return true;
    }

    private static class Field {
        char value;
        Set<Character> candidates = getAllValues();
        Set<Character> restricted = new HashSet<>();

        void trySet() {
            candidates.removeAll(restricted);
            if (value == '.') {
                if (candidates.size() == 1) {
                    value = candidates.stream().findFirst().get();
                }
            }
        }
    }

    private static Set<Character> getAllValues() {
        return Stream.iterate('1', (Character i) -> (Character) (char) (i.charValue() + 1)).limit(9).collect(Collectors.toSet());
    }
}