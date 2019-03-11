package yu.sort.QuickSort;

import yu.sort.Support;

import java.util.Arrays;

/**
 * @author yusiming
 * @date 2019/3/11 15:33
 */
public class QuickSort2 {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * left    -     less      -       k      -        more      -        right
     *      小于value      等于value      不确定             大于value
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int k = left;
        int less = left - 1;
        int more = right + 1;
        // 引入随机性
        Support.swap(arr, right, (int) (Math.random() * (right - left + 1) + left));
        int value = arr[right];
        while (k < more) {
            if (arr[k] < value) {
                Support.swap(arr, k++, ++less);
            } else if (arr[k] > value) {
                // 这里k不能增加，因为交换过来的值的大小不确定
                Support.swap(arr, k, --more);
            } else {
                k++;
            }
        }
        // 递归处理其他的无序部分
        quickSort(arr, left, less);
        quickSort(arr, more, right);
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int size = 100;
        int maxValue = 100;
        boolean isSuccess = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Support.generateRandomArray(size, maxValue);
            int[] arr2 = Support.copyArray(arr1);
            Arrays.sort(arr1);
            sort(arr2);
            isSuccess = Support.isEquals(arr1, arr2);
            if (!isSuccess) {
                System.out.println(Arrays.toString(arr1));
                break;
            }
        }
        System.out.println(isSuccess ? "success" : "failed");

    }
}
