package yu.timeComplexity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 理解时间复杂度
 * <p>
 * 题目:
 * 存在一个有序数组a，一个无序数组b，打印数组B中所有不在数组A中的元素，
 * 其中数组a的长度为N，数组b的长度为M。
 *
 * @author yusiming
 * @date 2019/3/11 13:59
 */
public class FindNumberNotInArray {
    /**
     * 方法一：对于数组B中的每一个数，都在数组A中遍历一遍，查询是否存在于数组A中。
     * 时间复杂度：O(N * M)
     */
    public void solve1(int[] a, int[] b) {
        if (a == null || a.length == 0 || b == null || b.length == 0) {
            return;
        }
        int N = a.length;
        int M = b.length;
        for (int i = 0; i < M; i++) {
            boolean isContains = false;
            for (int j = 0; j < N; j++) {
                if (b[i] == a[j]) {
                    isContains = true;
                    break;
                }
            }
            if (!isContains) {
                System.out.println(b[i]);
            }
        }
    }

    @Test
    void testSolve1() {
        int[] A = {1, 2, 3, 4};
        int[] B = {1, 2, 3, 20, 6, 5, 10};
        solve1(A, B);
    }

    /**
     * 方法二：对于数组B中的每一个数，每次都在数组A中通过二分的方式查找一遍
     * 时间复杂度：O( M * logN )
     */
    public void solve2(int[] a, int[] b) {
        if (a == null || a.length == 0 || b == null || b.length == 0) {
            return;
        }
        int M = b.length;
        for (int i = 0; i < M; i++) {
            if (!binarySort(a, b[i])) {
                System.out.println(b[i]);
            }
        }
    }

    /**
     * 二分查找
     */
    private boolean binarySort(int[] arr, int key) {
        if (arr == null) {
            throw new IllegalArgumentException("arr 不能为空");
        }
        int left = 0;
        int right = arr.length - 1;
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (key < arr[middle]) {
                right = middle - 1;
            } else if (key > arr[middle]) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSolve2() {
        int[] A = {1, 2, 3, 4};
        int[] B = {1, 2, 3, 20, 6, 5, 10};
        solve2(A, B);
    }

    /**
     * 方法三：将数组b排序，通过类似外排的方式依次遍历两个数组
     * 时间复杂度：O( M * logM ) + O(N + M)
     */
    public static void solve3(int[] a, int[] b) {
        if (a == null || a.length == 0 || b == null || b.length == 0) {
            return;
        }
        int N = a.length;
        int M = b.length;
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        while (i < N && j < M) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                System.out.println(b[j]);
                j++;
            } else {
                i++;
                j++;
            }
        }
        // 这里必须还有一次循环
        while (j < M) {
            System.out.println(b[j++]);
        }
    }

    @Test
    void testSolve3() {
        int[] A = {1, 2, 3, 4};
        int[] B = {1, 2, 3, 20, 6, 5, 10};
        solve3(A, B);
    }
}
