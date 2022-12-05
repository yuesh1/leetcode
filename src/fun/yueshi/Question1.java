package fun.yueshi;

/**
 * @author: yuesh1
 * create: 2022-12-05 23:10
 */
public class Question1 {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 4};
        int[] ints = twoSum(a, 6);
        System.out.println(ints);
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = 0;
        a:
        for (; i < nums.length; i++) {
            for (j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    break a;
                }
            }
        }
        return new int[]{i, j};
    }
}
