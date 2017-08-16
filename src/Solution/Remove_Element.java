package Solution;

/**
 * Created by zhangwei on 2017/7/25.
 */
public class Remove_Element {
    public static void main(String[] args) {
        int num=1;
        int a=num++;
        System.out.println(a + "\t" + num);
        num=1;
        int b=++num;
        System.out.println(b + "\t" + num);
    }
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i<nums.length;i++){
            if (nums[i]!=val){
                nums[count] = nums[i];
                count++;
            }

        }
        return count;
    }
}
