package com.faizan.leetcode.problems;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == '.') continue;
                if(!isValidPlacement(board, i, j, board[i][j])) return false;
            }
        }
        return true;
    }
    private static boolean isNumberInRow(char[][] board, int number, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if(column == i) continue;
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }


    private static boolean isNumberInColumn(char[][] board, int number, int column, int row) {
        for (int i = 0; i < 9; i++) {
            if(row == i) continue;
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(char[][] board, int row, int column, Character number) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if(row == i && column == j) continue;
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(char[][] board, int row, int column, Character number) {
        return !isNumberInRow(board, number, row, column) &&
                !isNumberInColumn(board, number, column, row) &&
                !isNumberInBox(board, row, column, number);
    }
}
