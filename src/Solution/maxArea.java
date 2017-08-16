package Solution;

/**
 * Created by zhangwei on 2017/7/19.
 */
public class maxArea {
    public static void main(String[] args) {
        int [] so = {1,2,3,4,5,2,3,4,6,7,8,1};
        int maxarea = maxArea(so);
        System.out.println(maxarea);
    }
    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length-1;
        int max_area = 0;
        while (left<right){
            max_area = Math.max(max_area,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]) left++;
            else right--;
        }
        return  max_area;
    }
}
