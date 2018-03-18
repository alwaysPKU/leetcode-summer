package Solution;

/**
 * Created by zhangwei on 2018/3/18.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode first = head;
        ListNode second = head.next;
        first.next = null;
        while (second.next!=null){
            ListNode tmp = second;
            second = second.next;
            tmp.next = first;
            first = tmp;
        }
        second.next = first;
        return second;
    }
}
