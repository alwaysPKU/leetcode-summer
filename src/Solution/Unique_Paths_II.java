package Solution;

/**
 * Created by zhangwei on 2017/9/24.
 *
 *Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.


 与1的不同是：
 *／／／／／／／／／／只要把障碍地方的解变为 0 就好。
 */
public class Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (rows<1) return 0;
        if (cols<1) return 0;
        if (obstacleGrid[0][0]==1||obstacleGrid[rows-1][cols-1]==1) return 0;
        int[] ans = new int[cols];
        ans[0] = 1;
        for (int j = 1; j < cols; j++) {
            if (obstacleGrid[0][j] == 0) {
                ans[j] = ans[j - 1];
            } else {
                ans[j] = 0;
            }
        }

        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) {
                ans[0] = 0;
            }
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ans[j] = 0;
                } else {
                    ans[j] += ans[j - 1];
                }
            }
        }

        return ans[cols - 1];
    }
}
