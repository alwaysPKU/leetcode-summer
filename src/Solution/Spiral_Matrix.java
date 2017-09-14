package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/9/14.
 *
 * 
 */
public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix==null||matrix.length==0||matrix[0].length==0) return res;
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while (top<=bottom&&left<=right){
            helper(res,matrix,top++,bottom--,left++,right--);
        }
        return res;
    }
    private void helper(List<Integer> res,int[][] matrix, int top, int bottom, int left,int right){
        int mark_left = left;
        int mark_top = top;
        while (left<=right){
            res.add(matrix[top][left++]);
        }
        if (left>right) left--;
        if (left==right&&top<bottom){
            while (left==right&&top<bottom){
                res.add(matrix[++top][right]);
            }
        }else return;
        if (mark_left==right)return;
        else {
            while (top==bottom&&mark_left<right){
                res.add(matrix[bottom][--right]);
            }
            while (right==mark_left&&mark_top<bottom-1){
                res.add(matrix[--bottom][mark_left]);
            }
        }
    }
}
