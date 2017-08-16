package Solution;

import java.util.HashSet;

/**
 * Created by zhangwei on 2017/8/1.
 */
public class Valid_Sudoku {
    public static void main(String[] args) {

    }
    private static boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();

        //行
        for (int i =0;i<9;i++){
            for (int j = 0;j<9;j++){
                if (board[i][j]=='.') continue;
                if (set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }
            set.clear();
        }

        //列
        for (int j = 0;j<9;j++){
            for (int i = 0;i<9;i++){
                if (board[i][j]=='.') continue;
                if (set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }
            set.clear();
        }

        //9宫格
        for (int k =0;k<9;k++){
            for (int i = k/3*3;i<k/3*3+3;i++){
                for (int j = (k%3)*3;j<(k%3)*3+3;j++){
                    if (board[i][j]=='.') continue;
                    if (set.contains(board[i][j])) return false;
                    else set.add(board[i][j]);
                }
            }
            set.clear();
        }
        return true;
    }



}
