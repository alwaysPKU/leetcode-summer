package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangwei on 2017/9/24.
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).
 *
 * 很可惜
 * TLE
 *
 *

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid
 (marked 'Finish' in the diagram below).

 How many possible unique paths are there?

 Above is a 3 x 7 grid. How many possible unique paths are there?

 Note: m and n will be at most 100.

 */
public class Unique_Paths {
    private int count =0;
    public int uniquePaths(int m, int n) {
        Map<Character,Integer> mark = new HashMap<>();
        mark.put('m',0);
        mark.put('n',0);
        helper(mark,m,n);
        return count;

    }
    private void helper(Map<Character,Integer> mark,int m ,int n){
        if (mark.get('m')==m-1||mark.get('n')==n-1){
            count++;
            return;
        }
        else {
            mark.put('m',mark.get('m')+1);
            helper(mark,m,n);
            mark.put('m',mark.get('m')-1);
            mark.put('n',mark.get('n')+1);
            helper(mark,m,n);
            mark.put('n',mark.get('n')-1);
        }
    }
    //mmp
    //只能用动态规划了
    //可是我DP不好😢
    //方法2：动态规划，定义一个二维数组 A[M][N]，
    // 从左上开始依次计算每一行的值，最后返回 A[M-1][N-1]即可，递推方程是：
    //A[I][J]=A[I-1][J]+A[I][J-1]；
    public int uniquePaths_II(int m, int n){
        int[][] a = new int[m][n];
        for (int i=0;i<m;i++){
            a[i][0]=1;
        }
        for (int i=0;i<n;i++){
            a[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = a[i-1][j] + a[i][j-1];
            }
        }
        return a[m-1][n-1];

    }

}
