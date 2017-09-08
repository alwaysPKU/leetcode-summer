package Solution;

/**
 * Created by zhangwei on 2017/9/7.
 * 维护两个标记
 * 一个全局变量
 * 一个局部变量
 */
public class Jump_Game {
    public boolean canJump(int[] nums) {
        int reach = 0;
        int lastReach = 0;
        for (int i = 0;i<=reach&&i<nums.length;i++){
            if (i>lastReach){
                lastReach = reach;
                if (lastReach>=nums.length-1) return true;
            }
            reach = Math.max(reach,i+nums[i]);
        }
        if (reach<nums.length-1) return false;
        return true;
    }
}
