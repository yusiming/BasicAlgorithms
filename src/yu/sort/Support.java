package yu.sort;

/**
 * @Auther yusiming
 * @Date 2018/12/14 11:44
 */
public class Support {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
