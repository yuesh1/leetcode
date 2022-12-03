package fun.yueshi.sorted;

/**
 * 插入排序
 *
 * @author: yuesh1
 * create: 2022-12-03 21:57
 */
public class InsertionSorting {
    public static void main(String[] args) {
        int[] a = {5, 3, 7, 1, 2, 6, 0};
//        sort0(a);
        sort1(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void sort0(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int index = i;
            while (index >= 1) {
                if (a[index] > a[index - 1]) {
                    break;
                }
                int tmp = a[index];
                a[index] = a[index - 1];
                a[index - 1] = tmp;
                index -= 1;
            }
        }
    }

    private static void sort1(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int index = i;
            int tmp = a[i];
            while (index > 0 && a[index - 1] > tmp) {
                a[index] = a[index - 1];
                index -= 1;
            }
            a[index] = tmp;
        }
    }
}
