package yu.matrixQuestions;

/**
 * 给定一个有N*M的整型矩阵matrix和一个整数K，
 * matrix的每一行和每一 列都是排好序的。实现一个函数，判断K 是否在matrix中。
 * 要求：
 * 时间复杂度为O(N+M)，额外空间复杂度为O(1)
 *
 * @author yusiming
 * @date 2019/2/20 09:39
 */
public class FindNumInSortedMatrix {
    public static boolean findNum(int[][] m, int num) {
        int aR = 0;
        int aC = m[0].length - 1;
        while (aR < m.length && aC > -1) {
            if (m[aR][aC] == num) {
                return true;
            } else if (m[aR][aC] > num) {
                aC--;
            } else {
                aR++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 3, 4, 5, 6},// 0
                {10, 12, 13, 15, 16, 17, 18},// 1
                {23, 24, 25, 26, 27, 28, 29},// 2
                {44, 45, 46, 47, 48, 49, 50},// 3
                {65, 66, 67, 68, 69, 70, 71},// 4
                {96, 97, 98, 99, 100, 111, 122},// 5
                {166, 176, 186, 187, 190, 195, 200},// 6
                {233, 243, 321, 341, 356, 370, 380} // 7
        };
        int K = 0;
        System.out.println(findNum(matrix, K));
    }
}
