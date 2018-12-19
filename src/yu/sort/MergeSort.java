package yu.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @Auther yusiming
 * @Date 2018/12/16 15:15
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    /**
     * 将数组arr 从 left 到 right 位置进行排序
     *
     * @param arr   被排序的数组
     * @param left  左边界
     * @param right 右边界
     */
    private static void sortProcess(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left + ((right - left) >> 1);
        // 将左半部分排序
        sortProcess(arr, left, middle);
        // 将右半部分排序
        sortProcess(arr, middle + 1, right);
        // 归并两部分
        merge(arr, left, middle, right);
    }

    /**
     * 将数组arr的left 到 middle 部分 和 middle + 1 到 right 部分进行归并
     *
     * @param arr    数组
     * @param left   左边界
     * @param middle 中间点
     * @param right  右边界
     */
    private static void merge(int[] arr, int left, int middle, int right) {
        int[] help = new int[right - left + 1];
        // i = 0,或者 i = left 都可以
        int i = 0;
        int p1 = left;
        int p2 = middle + 1;
        // 将左右两个部分中较小的数依次添加到辅助数组中
        while (p1 <= middle && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 下面的两个while有且只有一个被执行，
        // 如果p1 <= middle，p2越界
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        // 如果p2 <= right，p1越界
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        System.arraycopy(help, 0, arr, left, right - left + 1);
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int size = 100;
        int maxValue = 100;
        boolean isSuccess = true;
        long startTime = System.nanoTime();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Support.generateRandomArray(size, maxValue);
            int[] arr2 = Support.copyArray(arr1);
            int[] arr3 = Support.copyArray(arr1);
            Arrays.sort(arr2);
            mergeSort(arr3);
            if (!Support.isEquals(arr2, arr3)) {
                isSuccess = false;
                break;
            }
        }
        System.out.println(isSuccess ? "success" : "failed");
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000000.0);
    }
}


