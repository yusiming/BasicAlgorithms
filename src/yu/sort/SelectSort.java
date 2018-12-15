package yu.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @Auther yusiming
 * @Date 2018/12/14 13:34
 */
public class SelectSort {
    /**
     * 第一次遍历从 0 ~ N-1 中找出最小值的索引minIndex，
     * 将0位置的元素和minIndex位置的元素交换，这样0位置的元素就是 0 ~ N-1 中最小的元素了
     * <p>
     * 第二次遍历，从  1 ~ N-1 中找出最小值元素的索引,同样将1位置的元素和minIndex位置的元素交换
     * .....
     * 依次遍历下来，整个数组的排序就完成了
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            Support.swap(arr, i, minIndex);
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
            selectSort(arr3);
            if (!Support.isEquals(arr2, arr3)) {
                isSuccess = false;
                break;
            }
        }
        System.out.println(isSuccess ? "success!" : "failed!");
    }

}
