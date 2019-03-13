package yu.sort.heapSort;

import yu.sort.Support;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author yusiming
 * @date 2018/12/19 14:02
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 建立最大堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
//        // heapSize代表堆的大小
//        int heapSize = arr.length;
//        Support.swap(arr, 0, --heapSize);
//        // 每次都将最大元素放到heapSize - 1 的位置
//        while (heapSize > 0) {
//            heapify(arr, 0, heapSize);
//            Support.swap(arr, 0, --heapSize);
//        }
        // 下面的遍历方式也是可以的
        for(int i = arr.length - 1;i > 0; i--){
            Support.swap(arr,0,i);
            heapify(arr,0,i);
        }
    }

    /**
     * 元素的上浮操作
     *
     * @param arr   数组
     * @param index 插入的元素的索引
     */
    private static void heapInsert(int[] arr, int index) {
        // 如果index = 0，循环也会结束
        while (arr[index] > arr[(index - 1) / 2]) {
            Support.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 元素的上浮操作
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        while (2 * index + 1 <= heapSize - 1) {
            int k = 2 * index + 1;
            //  如果k < heapSize - 1，证明还有右子节点
            if (k < heapSize - 1 && arr[k] < arr[k + 1]) {
                k++;
            }
            // 如果父节点不小于子节点，证明堆已经有序了，直接break
            if (arr[index] >= arr[k]) {
                break;
            }
            // 如果执行到这里，证明父节点小于某一个子节点，交换之
            Support.swap(arr, index, k);
            index = k;
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int size = 100;
        int value = 100;
        boolean isSuccess = true;
        long startTime = System.nanoTime();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Support.generateRandomArray(size, value);
            int[] arr2 = Support.copyArray(arr1);
            int[] arr3 = Support.copyArray(arr1);
            Arrays.sort(arr2);
            heapSort(arr3);
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
