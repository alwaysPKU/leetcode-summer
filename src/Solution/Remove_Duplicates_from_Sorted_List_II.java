package Solution;

/**
 * Created by zhangwei on 2017/11/7.
 */
public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode mark = new ListNode(0);
        mark.next=head;
        ListNode previous = mark;
        while (previous.next!=null&&previous.next.next!=null){
            if (previous.next.val==previous.next.next.val){
                int tmp = previous.next.val;
                while (previous.next!=null&&previous.next.val==tmp){
                    previous.next=previous.next.next;
                }
            }else {
                previous=previous.next;
            }
        }
        return mark.next;
    }
}
