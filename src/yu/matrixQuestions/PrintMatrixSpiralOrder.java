package yu.matrixQuestions;

/**
 * 转圈打印矩阵
 *
 * @author yusiming
 * @date 2019/2/19 14:56
 */
public class PrintMatrixSpiralOrder {
    /**
     * 旋转打印矩阵matrix中的元素
     *
     * @param matrix
     */
    public static void spiralOrderPrint(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = matrix.length - 1;
        int bC = matrix[0].length - 1;
        while (aR <= bR && aC <= bC) {
            printEdge(matrix, aR++, aC++, bR--, bC--);
        }
    }

    /**
     * 打印以点a为左上角,点b为右下角的矩阵的四条边
     *
     * @param m 矩阵m
     * @param aR 点a所在的行
     * @param aC 点a所在的列
     * @param bR 点b所在的行
     * @param bC 点b所在的列
     */
    private static void printEdge(int[][] m, int aR, int aC, int bR, int bC) {
        // 如果两个顶点在同一行
        if (aR == bR) {
            for (int i = aC; i <= bC; i++) {
                System.out.print(m[aR][i] + " ");
            }
            // 如果两个顶点在同一列
        } else if (aC == bC) {
            for (int i = aR; i <= bR; i++) {
                System.out.print(m[i][aC] + " ");
            }
        } else {
            int curR = aR;
            int curC = aC;
            while (curC != bC) {
                System.out.print(m[aR][curC] + " ");
                curC++;
            }
            while (curR != bR) {
                System.out.print(m[curR][bC] + " ");
                curR++;
            }
            while (curC != aC) {
                System.out.print(m[bR][curC] + " ");
                curC--;
            }
            while (curR != aR) {
                System.out.print(m[curR][aC] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);
    }
}
