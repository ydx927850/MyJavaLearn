package algorithm.arrayProblem;

import java.util.Arrays;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/10/23 15:26
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        method2(matrix);
    }


    private static void method2(int[][] matrix) {
        //类环形旋转法
        int n = matrix.length;
        for (int t = 0; t < (n + 1) / 2; t++) {
            //从最外层到最内层，循环旋转四边元素
            for (int i = t; i < n-t-1; i++) {
                int tmp = matrix[t][i];
                matrix[t][i] = matrix[n - i - 1][t];
                matrix[n - i - 1][t] = matrix[n - t - 1][n - i - 1];
                matrix[n - t - 1][n - i - 1] = matrix[i][n - t - 1];
                matrix[i][n - t - 1] = tmp;
                System.out.println(Arrays.deepToString(matrix));
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotate(matrix);
    }
}