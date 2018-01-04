package Solution;

/**
 * Created by zhangwei on 2017/11/12.
 */
public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        if(head == null||head.next==null) return head;
        ListNode small = new ListNode(-1);
        ListNode newsmallhead = small;
        ListNode big = new ListNode(-1);
        ListNode newbighead = big;

        while (head!=null){
            if (head.val<x){
                small.next = head;
                small=small.next;
            }else {
                big.next=head;
                big=big.next;
            }
            head=head.next;
        }
        big.next=null;
        small.next=newbighead.next;
        return newsmallhead.next;

    }
}
