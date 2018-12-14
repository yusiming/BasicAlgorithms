package yu.sort;

/**
 * 插入排序
 *
 * @Auther yusiming
 * @Date 2018/12/14 13:50
 */
public class InsertSort {
    /**
     *
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                Support.swap(arr, j, j - 1);
            }
        }
    }
}
