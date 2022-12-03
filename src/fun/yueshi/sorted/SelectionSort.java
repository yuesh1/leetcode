package fun.yueshi.sorted;

/**
 * 选择排序
 *
 * @author: yuesh1
 * create: 2022-12-03 21:45
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 7, 1, 2, 6, 0};
        sort0(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void sort0(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int tmp = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[tmp]) {
                  tmp  = j;
                }
            }
            if (tmp != i) {
                int t = a[tmp];
                a[tmp] = a[i];
                a[i] = t;
            }
        }
    }
}
