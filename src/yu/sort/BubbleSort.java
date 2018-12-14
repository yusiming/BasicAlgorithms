package yu.sort;

/**
 * 冒泡排序
 *
 * @Auther yusiming
 * @Date 2018/12/14 11:48
 */
public class BubbleSort {
    /**
     * 第一轮比较：3 2 4 0 7 ==> 2 3 4 0 7 ==> 2 3 0 4 7
     * 第二轮比较：2 3 0 4 7 ==> 2 0 3 4 7
     * 第三轮比较：2 0 3 4 7 ==> 0 2 3 4 7
     * ......
     *
     * @param arr 需要排序的数组
     */
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
