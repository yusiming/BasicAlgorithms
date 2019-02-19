package yu.matrixQuestions;

/**
 * “之”字形打印矩阵：
 * 给定一个矩阵matrix，按照“之”字形的方式打印这 个矩阵，例如：
 * 1   2   3   4
 * 5   6   7   8
 * 9  10  11  12
 * “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11， 8，12
 *
 * @Auther yusiming
 * @Date 2019/2/19 20:04
 */
public class ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] m) {
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = m.length - 1;
        int endC = m[0].length - 1;
        boolean fromUp = false;
        while (aR != endR + 1) {
            print(m, aR, aC, bR, bC, fromUp);
            aR = (aC == endC) ? aR + 1 : aR;
            aC = (aC == endC) ? aC : aC + 1;
            bR = (bR == endR) ? bR : bR + 1;
            bC = (bR == endR) ? bC + 1 : bC;
            fromUp = !fromUp;
        }
    }

    /**
     * 打印以点a和点b为矩形的对角线上的数据
     * a右上角的顶点，b为左下角的顶点
     * fromUp为true代表从上往下打印
     */
    private static void print(int[][] m, int aR, int aC, int bR, int bC, boolean fromUp) {
        if (fromUp) {
            while (aR != bR + 1) {
                System.out.print(m[aR++][aC--] + " ");
            }
        } else {
            while (bR != aR - 1) {
                System.out.print(m[bR--][bC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);

    }
}
