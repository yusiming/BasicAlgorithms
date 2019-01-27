package yu.sort;

import java.util.Arrays;

/**
 * 非基于比较的计数排序
 *
 * @Auther yusiming
 * @Date 2019/1/27 11:12
 */
public class CountSort {
    /**
     * 计数排序
     *
     * @param arr 被排序的数组
     * @param min 数组中元素的最小值
     * @param max 数组中元素的最大值
     */
    public static void countSort(int[] arr, int min, int max) {
        if (arr == null || arr.length < 2 || max == min) {
            return;
        }
        if (min > max) {
            throw new IllegalArgumentException("参数不合法,min :" + min + " max : " + max);
        }
        int[] help = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            help[arr[i] - min]++;
        }
        int k = 0;
        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[i]; j++) {
                arr[k++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int size = 100;
        int value = 100;
        boolean isSuccess = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Support.generateRandomArray(size, value);
            int[] arr2 = Support.copyArray(arr1);
            int[] arr3 = Support.copyArray(arr1);
            countSort(arr2, -value, value);
            Arrays.sort(arr3);
            if (!Support.isEquals(arr2, arr3)) {
                isSuccess = false;
                break;
            }
        }
        System.out.println(isSuccess ? "success!" : "failed!");
    }
}
