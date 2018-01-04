package test;

import Solution.Plus_One;

/**
 * Created by zhangwei on 2017/9/25.
 */
public class test_for_plusOne {
    public static void main(String[] args) {
        int[] re = {9};
        Plus_One one = new Plus_One();
        for (int i =0;i<one.plusOne(re).length-1;i++){
            System.out.println(one.plusOne(re)[i]);
        }


    }
}
