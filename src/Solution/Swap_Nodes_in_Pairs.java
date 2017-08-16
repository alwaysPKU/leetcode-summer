package Solution;

/**
 * Created by zhangwei on 2017/7/24.
 */
public class Swap_Nodes_in_Pairs {
    public static void main(String[] args) {

    }
    public static ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head;

        ListNode fakehead = new ListNode(-1);
        fakehead.next = head;

        ListNode par1 = fakehead;
        ListNode par2 = head;

        while (par2!=null&&par2.next!=null){
            ListNode nextStart = par2.next.next;
            par2.next.next=par2;
            par1.next=par2.next;
            par2.next=nextStart;

            par1=par2;
            par2=par2.next;

        }
        return fakehead.next;

    }
}
