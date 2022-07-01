package com.faizan.leetcode.problems;

import java.util.*;

public class Soduko {
    public static void main(String[] args) {
        char[][] board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        solveSudoku(board);
    }
    public static List<Character> characters = new ArrayList<>(10);
    public static Hashtable<Integer, Set<Character>> row = new Hashtable<>();
    public static Hashtable<Integer, Set<Character>> coloumn = new Hashtable<>();
    public static Hashtable<Integer, Set<Character>> square = new Hashtable<>();
    //sudoku solver
    public static void solveSudoku(char[][] board) {
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
        fill(board);
        solveSudoku(board, 0, 0);
    }

    private static boolean solveSudoku(char[][] board, int i, int j) {
        if(i == 9) return true;
        if (board[i][j] == '.') {
            for(int f = 1; f<=9; f++) {
                if(fillBox(board, i, j, characters.get(f))){
                    boolean b;
                    if(j>=8) {
                        b = solveSudoku(board, i + 1, 0);
                    } else{
                        b = solveSudoku(board, i, j+1);
                    }
                    if(!b) {
                        remove(board[i][j], row, i);
                        remove(board[i][j], coloumn,j);
                        remove(board[i][j], square, (j/3)*3+(i/3));
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

    private static boolean fillBox(char[][] board, int i, int j, Character num) {
        if(!fill(num, row, i)) return false;
        if(!fill(num, coloumn,j)) {
            remove(num, row, i);
            return false;
        }
        if(!fill(num, square, (j/3)*3+(i/3))) {
            remove(num, row, i);
            remove(num, coloumn,j);
            return false;
        }
        board[i][j] = num;
        return true;
    }

    public static boolean fill(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(!fill(board[i][j], row, i)) return false;
                if(!fill(board[i][j], coloumn,j)) return false;
                if(!fill(board[i][j], square, (j/3)*3+(i/3))) return false;
            }
        }
        return true;
    }

    public static boolean fill(char value, Hashtable<Integer, Set<Character>> table, int index) {
        Set<Character> integers = null;
        if(table.containsKey(index)) {
            integers = table.get(index);
            if(integers.contains(value)) return false;
        }else {
            integers = new HashSet<>();
        }
        integers.add(value);
        table.put(index, integers);
        return true;
    }
    public static boolean remove(char value, Hashtable<Integer, Set<Character>> table, int index) {
        if(table.containsKey(index)) {
            Set<Character> integers = table.get(index);
            if(integers.contains(value)) {
                integers.remove(value);
                table.put(index, integers);
                return true;
            }
        }
        return false;
    }

}
