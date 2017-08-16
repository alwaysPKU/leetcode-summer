package Solution;
/**
 * Created by zhangwei on 2017/7/2.
 * test for git 2017/8/16
 */

public class Add_two_numbers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode l1 = new ListNode(2);
        l1.next =new ListNode(4);
        l1.next .next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next .next = new ListNode(4);

        ListNode l3 = addTwoNumbers(l1,l2);

        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;}
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode l3 = result;


        while (l1!=null||l2!=null){
            if(l1!=null){
                carry += l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                carry += l2.val;
                l2=l2.next;
            }

            l3.next = new ListNode(carry%10);
            carry=carry/10;
            l3=l3.next;
        }

        if (carry == 1)
            l3.next = new ListNode(1);
        return result.next;


    }

}