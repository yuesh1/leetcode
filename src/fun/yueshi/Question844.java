package fun.yueshi;

import java.util.Stack;

/**
 * @author: yuesh1
 * create: 2022-12-06 19:25
 */
public class Question844 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));//true
        System.out.println(backspaceCompare("bxj##tw", "bxj###tw"));//false
        System.out.println(backspaceCompare("xywrrmp", "xywrrm#p"));//false
        System.out.println(backspaceCompare("ab#c", "ad#c"));//true
        System.out.println(backspaceCompare("ab##", "c#d#"));//true
        System.out.println(backspaceCompare("a#c", "b"));// false
    }

    public static boolean backspaceCompare(String s, String t) {
//        return Objects.equals(dealWith(s), dealWith(t));

        char[] ss = s.toCharArray(), ts = t.toCharArray();
        int dp1 = 0, dp2 = 0, i = ss.length - 1, j = ts.length - 1;
        for (; i>=0||j>=0;i--,j--) {
            while (i>=0) {
                if (ss[i]=='#') {
                    dp1++;
                    i--;
                } else if (dp1 > 0) {
                    dp1--;
                    i--;
                } else {
                    break;
                }
            }

            while (j>=0) {
                if (ts[j]=='#') {
                    dp2++;
                    j--;
                } else if (dp2 > 0) {
                    dp2--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (ss[i] != ts[j]) return false;
            } else if (i >= 0 || j >= 0) {
                // 有其中一方已经遍历完整个字符串, 但另外一方没有遍历完整个字符串, 直接返回false
                return false;
            }
        }
        return true;
    }

    static String dealWith(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(aChar);
            }
        }
        StringBuilder r = new StringBuilder();
        while (!stack.isEmpty()) {
            r.append(stack.pop());
        }
        return r.toString();
    }
}
