package fun.yueshi;

import java.util.Stack;

/**
 * @author: yuesh1
 * create: 2022-12-06 10:53
 */
public class Question20 {
    public static void main(String[] args) {
isValid1("(){}()");
    }

    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
//        char[] chars = s.toCharArray();
//        Stack<Character> stack = new Stack<>();
//        for (char aChar : chars) {
//            if (isLeft(aChar)) {
//                stack.push(aChar);
//            }
//            if (isRight(aChar)) {
//                if (stack.empty()) {
//                    return false;
//                }
//                Character peek = stack.peek();
//                if (isMatch(peek, aChar)) {
//                    stack.pop();
//                } else {
//                    return false;
//                }
//            }
//        }
//        return stack.empty();
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (char aChar : chars) {
            if (isLeft(aChar)) {
                left.push(aChar);
            }
            if (isRight(aChar)) {
                if (left.empty()) {
                    return false;
                }
                Character peek = left.peek();
                if (isMatch(peek, aChar)) {
                    left.pop();
                    continue;
                }
                right.push(aChar);
            }
        }
        if (left.size() != right.size()) {
            return false;
        }
        while (!left.empty()) {
            if (!isMatch(left.pop(), right.pop())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public static boolean isRight(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public static boolean isMatch(char c1, char c2) {
        if (c1 == '(')
            return c2 == ')';
        if (c1 == '[')
            return c2 == ']';
        if (c1 == '{')
            return c2 == '}';
        return false;
    }
}
