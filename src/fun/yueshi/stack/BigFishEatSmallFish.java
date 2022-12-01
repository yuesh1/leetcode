package fun.yueshi.stack;

import java.util.Stack;

/**
 * 【题目】在水中有许多鱼，可以认为这些鱼停放在 x 轴上。再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。鱼的行为符合以下几个条件:
 * <p>
 * 所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；
 * <p>
 * 当方向相对时，大鱼会吃掉小鱼；
 * <p>
 * 鱼的大小都不一样。
 * <p>
 * 输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]
 * <p>
 * 输出：3
 */
public class BigFishEatSmallFish {
    public static void main(String[] args) {
        int[] Size = {4, 2, 5, 3, 1};
        int[] Dir = {1, 1, 0, 0, 0};
        System.out.println(solution(Size, Dir));
    }


    static int solution(int[] fishSize, int[] fishDirection) {
        // 首先拿到鱼的数量
        // 如果鱼的数量小于等于1，那么直接返回鱼的数量
        final int fishNumber = fishSize.length;
        if (fishNumber <= 1) {
            return fishNumber;
        }
        // 0表示鱼向左游
        final int left = 0;
        // 1表示鱼向右游
        final int right = 1;
        Stack<Integer> t = new Stack();
        for (int i = 0; i < fishNumber; i++) {
            // 当前鱼的情况：1，游动的方向；2，大小
            final int curFishDirection = fishDirection[i];
            final int curFishSize = fishSize[i];
            // 当前的鱼是否被栈中的鱼吃掉了
            boolean hasEat = false;
            // 如果栈中还有鱼，并且栈中鱼向右，当前的鱼向左游，那么就会有相遇的可能性
            while (!t.empty()
                    && fishDirection[t.peek()] == right
                    && curFishDirection == left) {
                // 如果栈顶的鱼比较大，那么把新来的吃掉
                if (fishSize[t.peek()] > curFishSize) {
                    hasEat = true;
                    break;
                }
                // 如果栈中的鱼较小，那么会把栈中的鱼吃掉，栈中的鱼被消除，所以需要弹栈。
                t.pop();
            }
            // 如果新来的鱼，没有被吃掉，那么压入栈中。
            if (!hasEat) {
                t.push(i);
            }
        }
        return t.size();
    }
}
