package Solution;

/**
 * Created by zhangwei on 2017/8/15.
 */
public class Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] a = {0,1,0,2,0,0,1,3,2,1,2,1};
        System.out.print(trap(a));

    }
    public static int trap(int[] height) {
        int volume = 0;

        int left = 0;
        int right = height.length-1;
        int counts =1;
        while (left<right){
            int min = Math.min(height[left],height[right]);
            if (min == height[left]){
                while (height[left+counts]<height[left]&&left+counts<right){
                    volume+=height[left]-height[left+counts];
                    counts++;
                }
                if (height[left+counts]>=height[left]&&left+counts<right){
                    left = left+counts;
                    counts=1;
                    continue;
                }
                if (left+counts==right) break;
            }

            if (min == height[right]){
                while (height[right-counts]<height[right]&&right-counts>left){
                    volume+=height[right]-height[right-counts];
                    counts++;
                }
                if (height[right-counts]>=height[right]&&right-counts>left){
                    right = right-counts;
                    counts=1;
                    continue;
                }
                if (right-counts==left) break;
            }


        }
        return volume;
    }
}
