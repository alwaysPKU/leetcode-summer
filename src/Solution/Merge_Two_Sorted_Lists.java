package Solution;

import java.util.List;

/**
 * Created by zhangwei on 2017/7/23.
 */
public class Merge_Two_Sorted_Lists {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){return l2;}
        if (l2==null){return l1;}

        ListNode tmpHead = new ListNode(-1);
        ListNode l3 = tmpHead;

        while (l1!=null&&l2!=null){
            if (l1.val<l2.val) {
                l3.next = l1;
                l3=l3.next;
                l1= l1.next;
            }
            else {
                l3.next = l2;
                l3=l3.next;
                l2=l2.next;
            }
        }
        if (l1==null) l3.next=l2;
        if (l2==null) l3.next = l1;
        return tmpHead.next;
    }
}
