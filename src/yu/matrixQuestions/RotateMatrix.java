package yu.matrixQuestions;

/**
 * 旋转正方形矩阵：
 * 给定一个整型正方形矩阵matrix，请把该矩阵调整成 顺时针旋转90度的样子
 *
 * @Auther yusiming
 * @Date 2019/2/19 18:56
 */
public class RotateMatrix {
    public static void rotate(int[][] m) {
        int a = 0;
        int b = 0;
        int c = m.length - 1;
        int d = c;
        while (a < c) {
            rotateEdge(m, a++, b++, c--, d--);
        }
    }

    public static void rotateEdge(int[][] m, int a, int b, int c, int d) {
        int times = c - a;
        for (int i = 0; i < times; i++) {
            int tmp = m[a][b + i];
            m[a][b + i] = m[c - i][b];
            m[c - i][b] = m[c][d - i];
            m[c][d - i] = m[b + i][d];
            m[b + i][d] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);
    }
}
