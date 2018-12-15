package yu.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @Auther yusiming
 * @Date 2018/12/14 13:50
 */
public class InsertSort {

    /**
     * 插入排序
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

    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean isSuccess = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Support.generateRandomArray(size, value);
            int[] arr2 = Support.copyArray(arr1);
            int[] arr3 = Support.copyArray(arr1);
            Arrays.sort(arr2);
            insertSort(arr3);
            if (!Support.isEquals(arr2, arr3)) {
                isSuccess = false;
                break;
            }
        }
        System.out.println(isSuccess ? "success!" : "failed!");
    }

}
