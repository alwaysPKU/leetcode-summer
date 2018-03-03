package Solution;

/**
 * Created by zhangwei on 2018/3/3.
 * cite ：http://blog.csdn.net/maxiaotiaoti/article/details/62230381
 */
public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null) return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] h = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            l[i] = 0;
            r[i] = n;
            h[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int cur_left = 0;
            int cur_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    h[j]+=1;
                    l[j] = Math.max(l[j], cur_left);
                }
                else {
                    h[j]=0;
                    l[j] = 0;
                    cur_left = j + 1;
                }
                }
            for(int j = n-1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    r[j] = Math.min(r[j], cur_right);
                }
                else{
                    r[j] = n;
                    cur_right = j;
                }
            }
            for(int j = 0; j < n; j++){
                res = Math.max(res, (r[j] - l[j]) * h[j]);
            }
            }
        return res;
        }
    }
