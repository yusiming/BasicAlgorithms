package yu.timeComplexity;

import java.util.Arrays;

/**
 * @Auther yusiming
 * @Date 2018/12/14 10:11
 */
public class Main {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 9};
        int[] B = {4, 2, 5, 7, 3, 9};
        fun1(A, B);
        fun2(A, B);
    }

    private static void fun1(int[] A, int[] B) {
        int N = A.length;
        int M = B.length;
        for (int i = 0; i < M; i++) {
            boolean isContains = false;
            for (int j = 0; j < N; j++) {
                if (B[i] == A[j]) {
                    isContains = true;
                    break;
                }
            }
            if (!isContains) {
                System.out.println(B[i]);
            }
        }
    }

    private static boolean binarySearch(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int middle;
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (k < arr[middle]) {
                end = middle - 1;
            } else if (k > arr[middle]) {
                start = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private static void fun2(int[] A, int[] B) {
        int N = A.length;
        int M = B.length;
        for (int i = 0; i < M; i++) {
            if (!binarySearch(A, B[i])) {
                System.out.println(B[i]);
            }
        }
    }

    public static void fun3(int[] A, int[] B) {
        // 将数组B排序
        Arrays.sort(B);
        int N = A.length;
        int M = B.length;

    }
}
