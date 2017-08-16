package Solution;

import java.util.HashSet;

/**
 * Created by zhangwei on 2017/8/1.
 *
 *
 *
 */
public class Sudoku_Solver {
    public static void main(String[] args) {

    }
    static void solveSudoku(char[][] board) {
        if (board==null||board.length==0) return;
        helper(board);
    }
    static boolean helper(char[][] board){
        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                if (board[i][j]=='.'){
                    for (char num ='1';num<='9';num++){
                        if (isvalid(board,i,j,num)) {
                            board[i][j] = num;
                            if (helper(board)) return true;
                            else board[i][j]='.';//回溯
                        }
                    }
                    return false;//无解
                }
            }
        }
        return true;
    }


    // 坐标i,j放入c是否合法
    static boolean isvalid (char[][] board , int i ,int j,char c){
        for (int row = 0;row<9;row++){
            if (board[row][j]==c) return false;
        }

        for (int column = 0 ;column<9;column++){
            if (board[i][column]==c) return false;
        }

        for (int row = i/3*3;row<i/3*3+3;row++){
            for (int column = j/3*3;column<j/3*3+3;column++){
                if (board[row][column]==c) return false;
            }
        }
        return true;
    }
}
