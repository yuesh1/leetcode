package fun.yueshi;

import java.util.Stack;

/**
 * @author: yuesh1
 * create: 2022-12-06 14:49
 */
public class Question155 {

    public static void main(String[] args) {
        Question155 q = new Question155();
        q.push(0);
        q.push(1);
        q.push(0);
        System.out.println(q.getMin());
        q.pop();
        System.out.println(q.getMin());
    }

    private Stack<Integer> stack;

    private ListNode head;

    public Question155() {
        stack = new Stack<Integer>();
        head = new ListNode();
    }

    public void push(int val) {
        stack.push(val);
        ListNode tmp = head;
        ListNode p = new ListNode(val, null);
        while (tmp.next != null && tmp.next.val <= val) {
            tmp = tmp.next;
        }
        ListNode q = tmp.next;
        p.next = q;
        tmp.next = p;
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        Integer val = stack.pop();
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
                return;
            } else {
                tmp = tmp.next;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return head.next.val;
    }

    static class MinStack {
        private ListNode head;

        public MinStack() {
        }

        public void push(int val) {
            if (head == null) {
                head = new ListNode(val, val, null);
            } else {
                head = new ListNode(val, Math.min(val, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        static class ListNode {
            int val;
            int min;
            ListNode next;

            public ListNode() {
            }

            public ListNode(int val, int min, ListNode next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }

}
