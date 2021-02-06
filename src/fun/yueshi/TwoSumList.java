package fun.yueshi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表
// 👍 10234 👎 0


/**
 * NO.1 两数之和
 *
 * @author dengzihui
 * @version 1.0
 * @date 2021/2/5 3:23 PM
 */
public class TwoSumList {


    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 4};
        int target = 6;
        for (int anInt : twoSum3(nums, target)) {
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
                return new int[] {firstIndex, lastIndex};
            }
        }
        return new int[] {};
    }

    /**
     * 双重for循环暴力解法 思路，游标从两边向中间游动，且在相等时结束，避免重复
     *
     * 2021/2/5 5:31 PM 作答
     *
     * Success:
     * 				Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 				Memory Usage:38.5 MB, less than 80.94% of Java online submissions.
     *
     */
    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (target != nums[i] + nums[j]) {
                    continue;
                }
                return new int[] {i, j};
            }
        }
        return new int[] {};
    }

    /**
     * 思路：两次循环，利用map的数据特征，进行比对
     *
     * Success:
     * 				Runtime:4 ms, faster than 34.26% of Java online submissions.
     * 				Memory Usage:38.7 MB, less than 42.38% of Java online submissions.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer item = map.get(nums[i]);
            if (Objects.nonNull(item) && i != item) {
                return new int[]{i, item};
            }
        }
        return new int[]{};

    }

}
