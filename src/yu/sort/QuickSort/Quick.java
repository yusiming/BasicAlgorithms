package yu.sort.QuickSort;

import yu.sort.Support;

import java.util.Arrays;

/**
 * 经典的快速排序
 *
 * @Auther yusiming
 * @Date 2018/12/19 10:49
 */
public class Quick {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int p = partition(arr, L, R);
        quickSort(arr, L, p - 1);
        quickSort(arr, p + 1, R);
    }

    private static int partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R + 1;
        int num = arr[R];
        while (L < more) {
            if (arr[L] < num) {
                Support.swap(arr, ++less, L++);
            } else if (arr[L] > num) {
                Support.swap(arr, --more, L);
            } else {
                L++;
            }
        }
        return L - 1;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int size = 100;
        int maxValue = 100;
        boolean isSuccess = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Support.generateRandomArray(size, maxValue);
            int[] arr2 = Support.copyArray(arr1);
            int[] arr3 = Support.copyArray(arr1);
            Arrays.sort(arr2);
            sort(arr3);
            if (!Support.isEquals(arr2, arr3)) {
                isSuccess = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                System.out.println(Arrays.toString(arr3));
                break;
            }
        }
        System.out.println(isSuccess ? "success!" : "failed!");
    }
}
