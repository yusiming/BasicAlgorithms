package yu.matrixQuestions;

/**
 * 转圈打印矩阵
 *
 * @Auther yusiming
 * @Date 2019/2/19 14:56
 */
public class PrintMatrixSpiralOrder {
    /**
     * 旋转打印矩阵matrix中的元素
     *
     * @param matrix 矩阵
     */
    public static void spiralOrderPrint(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a <= c && b <= d) {
            printEdge(matrix, a++, b++, c--, d--);
        }
    }

    /**
     * 打印以(a,b)为左上角,(c,d)为右下角的矩阵的四条边
     *
     * @param m 矩阵m
     * @param a 左上角的横坐标
     * @param b 左上角的纵坐标
     * @param c 右上角的横坐标
     * @param d 右上角的纵坐标
     */
    private static void printEdge(int[][] m, int a, int b, int c, int d) {
        // 如果两个顶点的横坐标相等
        if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.print(m[a][i] + " ");
            }
            //如果两个顶点的纵坐标相等
        } else if (b == d) {
            for (int i = a; i <= c; i++) {
                System.out.print(m[i][b] + " ");
            }
        } else {
            int curX = a;
            int curY = b;
            while (curY != d) {
                System.out.print(m[a][curY] + " ");
                curY++;
            }
            while (curX != c) {
                System.out.print(m[curX][d] + " ");
                curX++;
            }
            while (curY != b) {
                System.out.print(m[c][curY] + " ");
                curY--;
            }
            while (curX != a) {
                System.out.print(m[curX][b] + " ");
                curX--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);
    }
}
