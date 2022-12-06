package fun.yueshi;

import java.util.Stack;

/**
 * @author: yuesh1
 * create: 2022-12-06 16:46
 */
class Question232 {

    public static void main(String[] args) {
        Question232 myQueue = new Question232();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(3); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(4); // queue is: [1, 2] (leftmost is front of the queue)
        int pop = myQueue.pop();
        myQueue.push(5);
        int pop1 = myQueue.pop();
        int pop2 = myQueue.pop();
        int pop3 = myQueue.pop();
        int pop4 = myQueue.pop();
        myQueue.empty(); // return false
    }

    private Stack<Integer> leftStack;
    private Stack<Integer> rightStack;

    public Question232() {
        leftStack = new Stack<Integer>();
        rightStack = new Stack<Integer>();
    }

    public void push(int x) {
        leftStack.push(x);
    }

    public int pop() {
        if (rightStack.isEmpty()) {
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
        }
        return rightStack.pop();
    }

    public int peek() {
        if (rightStack.isEmpty()) {
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
        }
        return rightStack.peek();
    }

    public boolean empty() {
        return leftStack.isEmpty()&&rightStack.isEmpty();
    }
}
