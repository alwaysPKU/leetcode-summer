package Solution;

/**
 * Created by zhangwei on 2017/9/4.
 *
 * 顺时针旋转图片90度
 *
 * 主要是找到循环起始和终止的点
 * 从外向内旋转
 */
public class Rotate_Image {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i =0;i<=n/2;i++){
            for (int j = i;j<n-i-1;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }

}
