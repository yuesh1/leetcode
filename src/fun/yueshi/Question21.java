package fun.yueshi;

/**
 * @author: yuesh1
 * create: 2022-12-05 20:49
 */
public class Question21 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode listNode = mergeTwoLists3(list1, list2);
        System.out.println(listNode);
    }
    public static ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode tmp = new ListNode();
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists3(list1.next, list2);
            tmp.next = list1;
        } else {
            list2.next = mergeTwoLists3(list1, list2.next);
            tmp.next = list2;
        }
        return tmp.next;
    }
    static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode res = list1.val < list2.val ? list1 : list2;
        res.next = mergeTwoLists(res.next, list1.val >= list2.val ? list1 : list2);
        return res;
    }
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode headNode = new ListNode(); //创建首节点
        ListNode nextNode = headNode;  //当前节点指向首节点
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                nextNode.next = list1;
                list1 = list1.next;
            } else {
                nextNode.next = list2;
                list2 = list2.next;
            }
            nextNode = nextNode.next;
        }
        nextNode.next = list1 == null ? list2 : list1;
        return headNode.next;
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode tmp = list1;
        ListNode pre = new ListNode(0, list1);
        ListNode pre1 = new ListNode(0, list1);
        while (tmp != null && tmp.val < list2.val) {
            tmp = tmp.next;
            pre = pre.next;
        }
        ListNode t = list2.next;
        list2.next = tmp;
        pre.next = list2;
        if (tmp == list1) {
            pre1.next = pre.next;
        }
        return mergeTwoLists(pre1.next, t);
    }
}
