package Solution;

/**
 * Created by zhangwei on 2017/10/23.
 *
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.
 */
public class Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int row = matrix.length;
        int colmn = matrix[0].length;

        //int mark = matrix[row-1][0];
        int i = row-1;
        int j = 0;
        while (i>=0&&j<=colmn-1){
            if (matrix[i][j]==target)return true;
            else if (target>matrix[i][j]) j++;
            else if (target<matrix[i][j]) i--;
        }
        return false;

    }
}
