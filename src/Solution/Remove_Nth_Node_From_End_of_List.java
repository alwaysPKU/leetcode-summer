package Solution;

/**
 * Created by zhangwei on 2017/7/23.
 */
public class Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {

    }
//    public class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return null;
        ListNode left = head;
        ListNode right = head;
        for (int i=0;i<n;i++){
            right=right.next;
        }
        if (right==null)
            { head=head.next;
            return head;
            }
        while (right.next!=null){
            left=left.next;
            right=right.next;
        }
        left.next=left.next.next;
        return head;
    }
}
