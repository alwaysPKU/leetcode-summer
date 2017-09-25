package Solution;


/**
 * Created by zhangwei on 2017/9/25.
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 dp[i][j] = min(dp[i-1][j],dp[i][j-1])+grap(i,j)
 */
public class Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int [][] ans = new int[rows][cols];
        ans[0][0]=grid[0][0];
        for (int i =1;i<cols;i++){
            ans[0][i]=ans[0][i-1]+grid[0][i];
        }
        for (int i = 1;i<rows;i++){
            ans[i][0]=ans[i-1][0]+grid[i][0];
        }
        for (int i=1;i<rows;i++){
            for (int j = 1; j < cols; j++) {
                ans[i][j]=Math.min(ans[i-1][j],ans[i][j-1])+grid[i][j];
            }
        }
        return ans[rows-1][cols-1];

    }
}
