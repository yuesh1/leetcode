package fun.yueshi;

import java.util.Arrays;
import java.util.Queue;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * <p>
 * 实现 MovingAverage 类：
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * inputs = ["MovingAverage", "next", "next", "next", "next"]
 * inputs = [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 1
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= size <= 1000
 * -105 <= val <= 105
 * 最多调用 next 方法 104 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/qIsx9U
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingAverage {

    private int[] a;

    private int size;

    private int sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        a = new int[size];
    }

    public double next(int val) {
        sum += val;
        if (size == a.length) {
            sum -= a[0];
            for (int i = 0; i < size - 1; i++) {
                a[i] = a[i + 1];
            }
            a[size - 1] = val;
        } else {
            a[size] = val;
            size++;
        }
        return sum / (size + 0d);
    }


    public static void main(String[] args) throws InterruptedException {
        MovingAverage movingAverage = new MovingAverage(3);
        double a = movingAverage.next(1);
        double b = movingAverage.next(10);
        double c = movingAverage.next(3);
        double d = movingAverage.next(5);

        System.out.println(1);
    }

}
