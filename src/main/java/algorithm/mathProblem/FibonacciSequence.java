package algorithm.mathProblem;

/**
 * 分治法计算斐波那契额数列
 * 原始算法递归计算Fn-1 和Fn-2，子问题规模基本不会缩小，所耗时间为指数级O(Φ^n)
 * 为了减少计算消耗，采用平方递归实现 -- 矩阵的n次方
 * 定理：A矩阵为：
 * [1,1]
 * [1,0]
 * B矩阵为：
 * [Fn+1,Fn]
 * [Fn,Fn-1]
 * 则有 B=A^n
 * 这样只需要考虑四个数的乘法加法（参考乘方运算）,时间复杂度为O(lgn)
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/10 15:43
 */
public class FibonacciSequence {
    private static long[][] matrix = new long[2][2];

    public static void main(String[] args) {
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 0;
        long[][] temp;
        temp = pow(9,matrix);
        for (long[] a : temp) {
            for (long b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println("斐波那契数列的fn值为：" + temp[0][1]);
    }


    private static long[][] matrixMulti(long[][] m, long[][] n) {
        long[][] temp = new long[matrix.length][matrix.length];
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    temp[k][i] += m[k][j] * n[j][i];
                }
            }
        }
        return temp;
    }

    private static long[][] pow(long n,long[][] matrix) {
        long[][] temp;
        if (n == 1) {
            return matrix;
        } else {
            if (n % 2 != 0) {
//                temp = pow((n - 1) / 2,matrix);
//                temp = matrixMulti(temp, temp);
//                return matrixMulti(temp, matrix);
                return matrixMulti(pow((n-1)/2,matrixMulti(matrix,matrix)),matrix);
            } else {
//                temp = pow(n / 2,matrix);
//                temp = matrixMulti(temp, temp);
//                return temp;
                return pow(n/2,matrixMulti(matrix,matrix));
            }
        }
    }
}
