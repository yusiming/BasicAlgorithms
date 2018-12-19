package yu.sort.QuickSort;

import yu.sort.Support;

import java.util.Arrays;

/**
 * 改进的快速排序（三向切分的快速排序）
 *
 * @Auther yusiming
 * @Date 2018/12/18 10:54
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] p = partition(arr, L, R);
        // 经过partition之后，p[0] 到 p[1] 位置上的元素已经排好序了
        quickSort(arr, L, p[0] - 1);
        quickSort(arr, p[1] + 1, R);
    }

    /**
     * 这个方法的作用：
     * 将arr数组中大于arr[R]的元素放在数组右测
     * 将小于arr[R]的元素放在数组左侧
     * 将等于arr[R]的元素放在数组中间
     * <p>
     * 也就是说中的元素已经排好序了
     */
    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R + 1;
        int num = arr[R];
        while (L < more) {
            if (arr[L] < num) {
                // 交换了一个等于num的数来到L位置，或者等于区域不存在，自己跟自己交换
                Support.swap(arr, ++less, L++);
            } else if (arr[L] > num) {
                // 这里不应该 ++L，因为从--more位置交换过来的元素的值，是不确定的，
                // 这里会改变arr[R]上元素的值，所以不能使用arr[R]
                Support.swap(arr, L, --more);
            } else {
                L++;
            }
        }
        return new int[]{less + 1, more - 1};
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
            quickSort(arr3);
            if (!Support.isEquals(arr2, arr3)) {
                isSuccess = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                System.out.println(Arrays.toString(arr3));
                break;
            }
        }
        System.out.println(isSuccess ? "success!" : "failed!");
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000000.0);
    }
}

