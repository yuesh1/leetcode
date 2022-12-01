package fun.yueshi.stack;

import java.util.Stack;

/**
 * 【题目】字符串中只有字符'('和')'。合法字符串需要括号可以配对。比如：
 * <p>
 * 输入："()"
 * <p>
 * 输出：true
 * <p>
 * 解释：()，()()，(())是合法的。)(，()(，(()是非法的。
 */
public class StrVaild {

    public static void main(String[] args) {
        System.out.println(isValidWhitStack("()()"));
        System.out.println(isValidWithNum("()()"));
    }

    static boolean isValidWhitStack(String s) {
        // 当字符串本来就是空的时候，我们可以快速返回true
        if (s == null || s.length() == 0) {
            return true;
        }
        // 当字符串长度为奇数的时候，不可能是一个有效的合法字符串
        if (s.length() % 2 == 1) {
            return false;
        }
        // 消除法的主要核心逻辑:
        Stack<Character> t = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            // 取出字符
            char c = s.charAt(i);
            if (c == '(') {
                // 如果是'('，那么压栈
                t.push(c);
            } else if (c == ')') {
                // 如果是')'，那么就尝试弹栈
                if (t.empty()) {
                    // 如果弹栈失败，那么返回false
                    return false;
                }
                t.pop();
            }
        }
        return t.empty();
    }

    static boolean isValidWithNum(String s) {
        // 当字符串本来就是空的时候，我们可以快速返回true
        if (s == null || s.length() == 0) {
            return true;
        }
        // 当字符串长度为奇数的时候，不可能是一个有效的合法字符串
        if (s.length() % 2 == 1) {
            return false;
        }
        // 消除法的主要核心逻辑:
        int leftBraceNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            // 取出字符
            char c = s.charAt(i);
            if (c == '(') {
                // 如果是'('，那么压栈
                leftBraceNumber++;
            } else if (c == ')') {
                // 如果是')'，那么就尝试弹栈
                if (leftBraceNumber <= 0) {
                    // 如果弹栈失败，那么返回false
                    return false;
                }
                --leftBraceNumber;
            }
        }
        return leftBraceNumber == 0;
    }
}
