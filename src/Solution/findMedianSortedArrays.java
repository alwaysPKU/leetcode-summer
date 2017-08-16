package Solution;

/**
 * Created by zhangwei on 2017/7/18.
 */
public class findMedianSortedArrays {
    public static void main(String[] args) {
        int [] a = {6};
        int [] b = {1,2,3,4,5};
        double re = findMediannumber(a,b);
        System.out.print(re);

    }
    public static double findMediannumber(int[] a,int[] b){
        int m = a.length;
        int n = b.length;
        int total=m+n;
        if (total%2!=0){
            return (double)findKth(a,0,m-1,b,0,n-1,total/2+1);
        }
        else {
            double x =findKth(a,0,m-1,b,0,n-1,total/2);
            double y =findKth(a,0,m-1,b,0,n-1,total/2+1);
            return (x+y)/2.0;
        }


    }
    public static int findKth(int[] a,int aStart,int aEnd,int[] b,int bStart,int bEnd,int K){
        int m = aEnd-aStart+1;
        int n = bEnd-bStart+1;

        if (m>n){
            return findKth(b,bStart,bEnd,a,aStart,aEnd,K);
        }
        if (m==0){
            return b[K-1];
        }
        if (K==1){
            return Math.min(a[aStart],b[bStart]);
        }

        int partA = Math.min(K/2,m);
        int partB = K-partA;
        if (a[aStart+partA-1]<b[bStart+partB-1]){
            return findKth(a,aStart+partA,aEnd,b,bStart,bEnd,K-partA);
        }
        if (a[aStart+partA-1]==b[bStart+partB-1]){
            return a[aStart+partA-1];
        }
        else return findKth(a,aStart,aEnd,b,bStart+partB,bEnd,K-partB);
    }
}
