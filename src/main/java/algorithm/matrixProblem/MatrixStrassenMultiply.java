package algorithm.matrixProblem;

/**
 * 矩阵乘法的Strassen算法 矩阵分块乘法（递归）
 * 时间复杂度：O(n^lg7)
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/9 16:26
 */
public class MatrixStrassenMultiply {
    public static void main(String[] args) {

    }

    @SuppressWarnings("Duplicates")
    private static void strassen(int n, int[][] matrixA, int[][] matrixB, int[][] result) {
        if (n == 1) {
            result[0][0] = matrixA[0][0] * matrixB[0][0];
            return;
        }
        int halfSize = n / 2;
        //divide
        int[][] A11 = new int[halfSize][halfSize];
        int[][] A12 = new int[halfSize][halfSize];
        int[][] A21 = new int[halfSize][halfSize];
        int[][] A22 = new int[halfSize][halfSize];
        int[][] B11 = new int[halfSize][halfSize];
        int[][] B12 = new int[halfSize][halfSize];
        int[][] B21 = new int[halfSize][halfSize];
        int[][] B22 = new int[halfSize][halfSize];
        for (int i = 0; i < halfSize; i++) {
            for (int j = 0; j < halfSize; j++) {
                A11[i][j] = matrixA[i][j];
                A12[i][j] = matrixA[i][halfSize + j];
                A21[i][j] = matrixA[i + halfSize][j];
                A22[i][j] = matrixA[i + halfSize][j + halfSize];

                B11[i][j] = matrixB[i][j];
                B12[i][j] = matrixB[i][halfSize + j];
                B21[i][j] = matrixB[i + halfSize][j];
                B22[i][j] = matrixB[i + halfSize][j + halfSize];
            }
        }
        //conquer
        int[][] C1 = new int[halfSize][halfSize];
        int[][] C2 = new int[halfSize][halfSize];
        int[][] C3 = new int[halfSize][halfSize];
        int[][] C4 = new int[halfSize][halfSize];
        int[][] P1 = new int[halfSize][halfSize];
        int[][] P2 = new int[halfSize][halfSize];
        int[][] P3 = new int[halfSize][halfSize];
        int[][] P4 = new int[halfSize][halfSize];
        int[][] P5 = new int[halfSize][halfSize];
        int[][] P6 = new int[halfSize][halfSize];
        int[][] P7 = new int[halfSize][halfSize];
        int[][] tempA = new int[halfSize][halfSize];
        int[][] tempB = new int[halfSize][halfSize];
        matrixSub(B12, B22, tempB);
        strassen(halfSize, A11, tempB, P1);

        matrixAdd(A11, A12, tempA);
        strassen(halfSize, tempA, B22, P2);

        matrixAdd(A21, A22, tempA);
        strassen(halfSize, tempA, B11, P3);

        matrixSub(B21, B11, tempB);
        strassen(halfSize, A22, tempB, P4);

        matrixAdd(A11, A22, tempA);
        matrixAdd(B11, B22, tempB);
        strassen(halfSize, tempA, tempB, P5);

        matrixSub(A12, A22, tempA);
        matrixAdd(B21, B22, tempB);
        strassen(halfSize, tempA, tempB, P6);

        matrixSub(A11, A21, tempA);
        matrixAdd(B11, B12, tempB);
        strassen(halfSize, tempA, tempB, P7);

        matrixAdd(P5, P4, C1);
        matrixSub(C1, P2, C1);
        matrixAdd(C1, P6, C1);

        matrixAdd(P1, P2, C2);

        matrixAdd(P3, P4, C3);

        matrixAdd(P5, P1, C4);
        matrixSub(C4, P3, C4);
        matrixSub(C4, P7, C4);

        //combine
        for (int i = 0; i < halfSize; i++) {
            for  (int j = 0; j < halfSize; j++) {
                result[i][j] = C1[i][j];
                result[i][j + halfSize] = C2[i][j];
                result[i + halfSize][j] = C3[i][j];
                result[i + halfSize][j + halfSize] = C4[i][j];
            }
        }
    }


    private static void matrixSub(int[][] matrixA, int[][] matrixB, int[][] result) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
    }

    private static void matrixAdd(int[][] matrixA, int[][] matrixB, int[][] result) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
    }
}
