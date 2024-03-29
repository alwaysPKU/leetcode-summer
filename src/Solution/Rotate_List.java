package Solution;

/**
 * Created by zhangwei on 2017/9/24.
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode item = head;
        ListNode slow = head;
        ListNode mid = head;
        ListNode fast = head;
        int len = 0;
        while (item!=null){
            ++len;
            item=item.next;
        }
        if (len==1||len==0||k==0) return head;
        k=k%len;
        if (k==0) return head;
        for (int i = 0; i <k; i++) {
            fast=fast.next;
        }
        mid=mid.next;
        while (fast.next!=null){
            slow=slow.next;
            mid=mid.next;
            fast=fast.next;
        }
        slow.next=null;
        fast.next=head;
        return mid;

    }

}
