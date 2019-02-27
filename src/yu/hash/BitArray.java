package yu.hash;

/**
 * 只修改数组某一位的值，模拟bite数组
 *
 * @Auther yusiming
 * @Date 2019/2/27 15:53
 */
public class BitArray {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        // 这里只是简单模拟，数值可以是随意的
        int index = 1000;
        int intIndex = index / arr.length;
        int bitIndex = index % 32;
        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));
    }
}
