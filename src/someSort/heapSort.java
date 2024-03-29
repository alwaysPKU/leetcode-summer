package someSort;

/**
 * Created by zhangwei on 2017/7/20.
 * 堆排序
 *
 * 不稳定
 * 我们知道堆的结构是节点i的孩子为2 * i和2 * i + 1节点，
 * 大顶堆要求父节点大于等于其2个子节点，
 * 小顶堆要求父节点小于等于其2个子节点。
 * 在一个长为n 的序列，
 * 堆排序的过程是从第n / 2开始和其子节点共3个值选择最大（大顶堆）
 * 或者最小（小顶堆），这3个元素之间的选择当然不会破坏稳定性。
 * 但当为n / 2 - 1， n / 2 - 2， ... 1这些个父节点选择元素时，
 * 就会破坏稳定性。有可能第n / 2个父节点交换把后面一个元素交换过去了，
 * 而第n / 2 - 1个父节点把后面一个相同的元素没 有交换，
 * 那么这2个相同的元素之间的稳定性就被破坏了。
 * 所以，堆排序不是稳定的排序算法。
 */
public class heapSort {
//    public static void main(String[] args) {
//        int[] a = {834,4,4654,4,6,46,84,7,45,68,22,44,66,78,31};
//        int[] result =heap_sort(a);
//        for (int i =0;i<result.length;i++){
//            System.out.println(result[i]);
//        }
//
//    }
    public static int[] heap_sort(int[] a){
        a=build_max_heap(a,a.length);//把a建成最大堆
        int[] res = new int[a.length];
        int j = 0;
        for (int i =a.length;i>0;i--){
            res[j] = a[0];
            a[0]=a[i-1];
            j++;
            Adjust_Down(a,0,i);
        }
        return res;
    }

    public static int[] build_max_heap(int[] a,int len){

        for (int i=len/2-1; i>=0;i--){
            Adjust_Down(a,i,len);
        }
        return a;
    }



    private static void Adjust_Down(int[] array,int k,int length){
        int temp = array[k];
        for(int i=2*k+1; i<length-1; i=2*i+1){    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if(i<length && array[i]<array[i+1]){  //取节点较大的子节点的下标
                 i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if(temp>=array[i]){  //根节点 >=左右子女中关键字较大者，调整结束
                break;
            }else{   //根节点 <左右子女中关键字较大者
                array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp;  //被调整的结点的值放人最终位置
    }
}
