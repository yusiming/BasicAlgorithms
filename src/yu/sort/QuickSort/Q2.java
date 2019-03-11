package yu.sort.QuickSort;

import yu.sort.Support;

import java.util.Arrays;

/**
 * 荷兰国旗问题：
 * 给定一个数组arr，和一个数num，
 * 请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。
 *
 * @author yusiming
 * @date 2018/12/18 10:14
 */
public class Q2 {
    /**
     * 注意：方法会返回数组中等于区域的范围[left,right]
     * [L......less......current......more......R]
     * L到less之间的数小于num
     * less到current之间的数等于num
     * more到R之间的数大于num
     * current到more之间的数待定
     */
    public static int[] solve(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < num) {
                // 交换了一个等于num的数来到L位置，或者等于区域不存在，自己跟自己交换
                Support.swap(arr, ++less, L++);
            } else if (arr[L] > num) {
                // 这里不应该 ++L，因为从--more位置交换过来的元素的值，是不确定的
                Support.swap(arr, L, --more);
            } else {
                L++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 2, 3, 5, 1, 6, 8, 2, 9, 4, 8, 5};
        Q2.solve(arr, 0, arr.length - 1, 5);
        System.out.println(Arrays.toString(arr));
    }
}
