package Solution;

/**
 * Created by zhangwei on 2017/10/23.
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int row = matrix.length;
        int colmn = matrix[0].length;

        int low_1 =0;
        int high_1 = row-1;

        int low_2 =0;
        int high_2 = colmn-1;

        while (low_1<=high_1){
            int mid_1 = (low_1+high_1)/2;
            if (target<matrix[mid_1][0]) high_1=mid_1-1;
            else if (target>matrix[mid_1][colmn-1]) low_1=mid_1+1;
            else {
                while (low_2<=high_2){
                    int mid_2 = (low_2+high_2)/2;
                    if (matrix[mid_1][mid_2]==target) return true;
                    else if (target>matrix[mid_1][mid_2]) low_2=mid_2+1;
                    else high_2=mid_2-1;
                }
                return false;
            }
        }
        return false;

    }
}
