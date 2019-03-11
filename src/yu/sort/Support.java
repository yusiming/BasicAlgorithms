package yu.sort;

/**
 * @author yusiming
 * @date 2018/12/14 11:44
 */
public class Support {
    /**
     * 交换数组中两个索引位置的元素
     *
     * @param arr 数组
     * @param i   索引1
     * @param j   索引2
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 随机数组发生器
     *
     * @param size  数组的大小为 0 - size 之间
     * @param value value数组中数的大小范围 -vale ~ value 之间
     * @return 随机数组
     */
    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // 可能产生的数的范围  -value  ~  value
            arr[i] = (int) ((value + 1) * Math.random()) - (int) ((value + 1) * Math.random());
        }
        return arr;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param a 数组a
     * @param b 数组b
     * @return 如果相等返回true，否则返回false
     */
    public static boolean isEquals(int[] a, int[] b) {
        // 这里实际上包含了 null == null 的情况
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        int length = a.length;
        if (b.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 返回一个数的拷贝
     *
     * @param arr 被拷贝的数组
     * @return 返回新的拷贝数组
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int length = arr.length;
        int[] res = new int[length];
        System.arraycopy(arr, 0, res, 0, length);
        return res;
    }
}
