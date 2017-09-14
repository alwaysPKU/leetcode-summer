package Solution;

/**
 * Created by zhangwei on 2017/9/14.
 *
 * 输出入n，输出一个n^2的螺旋矩阵
 */
public class Spiral_Matrix_II {
    public static void main(String[] args) {
        int[][] test = generateMatrix(6);
        for (int i = 0;i<test.length;i++){
            System.out.println();
            for (int j = 0;j<test[0].length;j++){
                System.out.print(test[i][j]+"  ");
            }
        }
    }
    public static int m = 1;
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int bottom =n-1;
        int left = 0;
        int right = n-1;
        while (top<=bottom&&left<=right){
            helper(res,top++,bottom--,left++,right--);
        }
        return res;

    }
    public static void helper(int[][] matrix, int top, int bottom, int left, int right){
        int mark_left = left;
        int mark_top = top;
        while (left<=right){
            matrix[top][left++]=m++;
        }
        if (left>right) left--;
        if (left==right&&top<bottom){
            while (left==right&&top<bottom){
                matrix[++top][right]=m++;
            }
        }else return;
        if (mark_left==right)return;
        else {
            while (top==bottom&&mark_left<right){
                matrix[bottom][--right]=m++;
            }
            while (right==mark_left&&mark_top<bottom-1){
                matrix[--bottom][mark_left]=m++;
            }
        }
    }
}
