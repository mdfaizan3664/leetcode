package com.faizan.leetcode.problems;

import java.util.*;

public class Soduko {
    public Soduko() {
        characters.add(0, '0');
        characters.add(1, '1');
        characters.add(2, '2');
        characters.add(3, '3');
        characters.add(4, '4');
        characters.add(5, '5');
        characters.add(6, '6');
        characters.add(7, '7');
        characters.add(8, '8');
        characters.add(9, '9');
    }

    public static final List<Character> characters = new ArrayList<>(10);
    //sudoku solver
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int i, int j) {
        if(i == 9) return true;
        if (board[i][j] == '.') {
            for(int f = 1; f<=9; f++) {
                if(isValidPlacement(board, i, j, characters.get(f))){
                    board[i][j] = characters.get(f);
                    boolean b;
                    if(j>=8) {
                        b = solveSudoku(board, i + 1, 0);
                    } else{
                        b = solveSudoku(board, i, j+1);
                    }
                    if(!b) {
                        board[i][j] = '.';
                    }
                    if(b) return true;
                }
            }
            return false;
        }else {
            if(j>=8) {
                return solveSudoku(board, i + 1, 0);
            } else{
                return solveSudoku(board, i, j+1);
            }
        }
    }

    private static boolean isNumberInRow(char[][] board, int number, int row) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(char[][] board, int number, int column) {
        for (int i = 0; i < 9; i++) {
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
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(char[][] board, int row, int column, Character number) {
        return !isNumberInRow(board, number, row) &&
                !isNumberInColumn(board, number, column) &&
                !isNumberInBox(board, row, column, number);
    }

}
