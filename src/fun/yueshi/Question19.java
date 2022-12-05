package fun.yueshi;

import java.util.ArrayList;

/**
 * @author: yuesh1
 * create: 2022-12-05 22:06
 */
public class Question19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int size = 0;
        ArrayList<ListNode> list = new ArrayList();
        while(tmp != null) {
            size++;
            list.add(tmp);
            tmp = tmp.next;
        }
        if(size == 1) {
            return null;
        }
        if (size == n) {
            return head.next;
        }
        ListNode l1 = list.get(size - n - 1);
        l1.next = l1.next.next;
        return head;
    }
}
