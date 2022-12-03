package fun.yueshi.sorted;

/**
 * @author: yuesh1
 * create: 2022-12-03 21:17
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 7, 1, 2, 6, 0};
//        sort0(a);
        sort1(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sort0(int[] a) {
        int tmp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i -1; j++) {
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public static void sort1(int[] a) {
        int index = a.length - 1;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < index; i++) {
                if (a[i] > a[i+1]) {
                    changed = true;
                    int tmp = a[i];
                    a[i]=a[i+1];
                    a[i+1]=tmp;
                }
            }
        }
    }
}
