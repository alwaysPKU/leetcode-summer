package Solution;

import java.util.ArrayList;

/**
 * Created by zhangwei on 2017/7/24.
 */
public class Merge_k_Sorted_Lists {
    public static void main(String[] args) {

    }
    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0||lists==null) return null;
        int nums = lists.length;
        return helper(lists,0,nums-1);
    }

    private static ListNode helper(ListNode[] lists,int l,int r){
        if (l<r){
            int mid=(l+r)/2;
            return merge2list(helper(lists,l,mid),helper(lists,mid+1,r));
        }
        return lists[l];
    }

    private static ListNode merge2list(ListNode l1,ListNode l2){
        ListNode tmp = new ListNode(-1);
        ListNode l3 = tmp;
        if (l1==null) return l2;
        if (l2==null) return l1;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                l3.next=l1;
                l3=l3.next;
                l1=l1.next;
            }else {
                l3.next=l2;
                l3=l3.next;
                l2=l2.next;
            }
        }
        if (l1==null) l3.next=l2;
        if (l2==null) l3.next=l1;
        return tmp.next;
    }
}
