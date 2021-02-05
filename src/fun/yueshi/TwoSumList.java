package fun.yueshi;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * NO.1 两数之和
 *
 * @author dengzihui
 * @version 1.0
 * @date 2021/2/5 3:23 PM
 */
public class TwoSumList {


    public static void main(String[] args) {
        int[] nums = new int[] {3, 3};
        int target = 6;
        for (int anInt : twoSum(nums, target)) {
            System.out.println(anInt);
        }
    }

    /**
     * 思路，依据list的 indexof 方法进行计算 在元素相等的时候，一个取正序，一个取倒序，并判断最终的index是否相等，并输出
     *
     * 2021/2/5 5:13 PM 作答
     *
     * Success:
     * 		Runtime:4 ms, faster than 34.71% of Java online submissions.
     * 		Memory Usage:38.7 MB, less than 38.51% of Java online submissions.
     */
    public static int[] twoSum(int[] nums, int target) {

        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for (Integer itm : numsList) {
            int firstIndex = numsList.indexOf(itm);
            int lastIndex = numsList.lastIndexOf(target - itm);
            if (numsList.contains(target - itm)
                && !Objects.equals(firstIndex, lastIndex)) {
                return new int[]{firstIndex, lastIndex};
            }
        }
        return new int[]{};
    }

}
