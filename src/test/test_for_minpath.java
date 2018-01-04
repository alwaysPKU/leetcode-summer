package test;

import Solution.Minimum_Path_Sum;

/**
 * Created by zhangwei on 2017/9/25.
 */
public class test_for_minpath {
    public static void main(String[] args) {
        int [][] a  = {{1,2},{1,1}};
        Minimum_Path_Sum test = new Minimum_Path_Sum();
        int ans =test.minPathSum(a);
    }

}
