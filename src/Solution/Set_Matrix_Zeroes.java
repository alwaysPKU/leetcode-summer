package Solution;

import java.util.*;

/**
 * Created by zhangwei on 2017/10/23.
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.

 Follow up:
 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?


 */
public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        Set<Integer> row = new HashSet<>();
        Set<Integer> colmn = new HashSet<>();

        for (int i = 0;i<rows;i++){
            for (int j = 0; j<columns;j++){
                if (matrix[i][j]==0){
                    if (!row.contains(i)){
                        row.add(i);
                    }
                    if (!colmn.contains(j)){
                        colmn.add(j);
                    }
                }
            }
        }

        for (int i : row){
            for (int j=0;j<columns;j++){
                matrix[i][j]=0;
            }
        }
        for (int i : colmn){
            for (int j =0;j<rows;j++){
                matrix[j][i]=0;
            }
        }
    }
}
