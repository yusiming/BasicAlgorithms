package yu.sort.QuickSort;

import yu.sort.Support;

import java.util.Arrays;

/**
 * 给定一个数组arr，和一个数num，请把小于等于num的数放在数 组的左边，大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 *
 * @Auther yusiming
 * @Date 2018/12/18 09:53
 */
public class Q1 {
    public static void solve(int[] arr, int num) {
        if (arr == null || arr.length <= 2) {
            return;
        }
        int k = -1;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                Support.swap(arr, ++k, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,7,2, 3, 1, 6, 8, 2, 9, 4, 8};
        Q1.solve(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}
