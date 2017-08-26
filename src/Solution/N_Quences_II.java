package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/8/25.
 * 因为这个问题是典型的NP问题，所以在时间复杂度上就不用纠结了，肯定是指数量级的。
 * 下面我们来介绍这个题的基本思路。
 * 主要思想就是一句话：用一个循环递归处理子问题。
 * 这个问题中，在每一层递归函数中，我们用一个循环把一个皇后填入对应行的某一列中，
 * 如果当前棋盘合法，我们就递归处理先一行，找到正确的棋盘我们就存储到结果集里面。
 * 这种题目都是使用这个套路，就是用一个循环去枚举当前所有情况，
 * 然后把元素加入，递归，再把元素移除，
 * 这道题目中不用移除的原因是我们用一个一维数组去存皇后在对应行的哪一列，
 * 因为一行只能有一个皇后，如果二维数组，那么就需要把那一行那一列在递归结束后设回没有皇后，所以道理是一样的。
 *
 * 这道题最后一个细节就是怎么实现检查当前棋盘合法性的问题，因为除了刚加进来的那个皇后，
 * 前面都是合法的，我们只需要检查当前行和前面行是否冲突即可。
 * 检查是否同列很简单，检查对角线就是行的差和列的差的绝对值不要相等就可以。
 */
public class N_Quences_II {
    int total = 0;
    public int totalNQueens(int n ){
        List<List<String>> result = new ArrayList<>();
        int[] queenList = new int[n];//queenList[i]表示第i行，queenist[i]列放一个棋子
        placeQueen(queenList,0,n,result);
        return total;

    }
//    public static List<List<String>> solveNQueens(int n) {
//        List<List<String>> result = new ArrayList<>();
//        int[] queenList = new int[n];//queenList[i]表示第i行，queenist[i]列放一个棋子
//        placeQueen(queenList,0,n,result);
//        return result;
//    }

    public void placeQueen(int[] queenList,int row,int n,List<List<String>> result){
        //如果已经填满，生成一个结果
        if (row==n){
            total+=1;
//            List<String> list = new ArrayList<>();
//            for (int i = 0;i<n;i++){
//                String str = "";
//                for (int j =0;j<n;j++){
//                    if (queenList[i]==j){
//                        str+='Q';
//                    }else {
//                        str+='.';
//                    }
//                }
//                list.add(str);//把每一行的String加入list
//            }
//            result.add(list);//把一个结果加入result
            return;//有没有都ok
        }
        //循环每一列
        for (int j=0;j<n;j++){
            if (isValid(queenList,row,j)){
                queenList[row]=j;
                placeQueen(queenList,row+1,n,result);
            }
        }
    }
    public static boolean isValid(int[] queenList,int row,int j){
        for (int i = 0;i<row;i++){
            int item = queenList[i];
            if (item == j||item+row-i==j||item-row+i==j ) return false;
        }
        return true;
    }
}
