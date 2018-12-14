package yu.sort;

/**
 * 冒泡排序
 *
 * @Auther yusiming
 * @Date 2018/12/14 11:48
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    Support.swap(arr, i, i + 1);
                }
            }
        }
    }
}
