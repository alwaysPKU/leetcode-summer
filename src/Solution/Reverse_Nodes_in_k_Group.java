package Solution;

/**
 * Created by zhangwei on 2017/7/24.
 */
public class Reverse_Nodes_in_k_Group {
    public static void main(String[] args) {

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || k ==1) return head;
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;

        int count =0;

        ListNode pre = fakehead;
        ListNode cur = head;

        while (cur!=null){
            count++;
            ListNode next = cur.next;
            if (count==k){
                pre = reverse(pre, next);
                count=0;
            }
            cur = next;
        }
        return fakehead.next;

    }
    private static ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur!=next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

}
