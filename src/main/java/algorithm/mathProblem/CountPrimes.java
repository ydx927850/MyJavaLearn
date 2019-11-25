package algorithm.mathProblem;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量统计所有小于非负整数 n 的质数的数量
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(2));
    }

    /**
     * 埃拉托斯特尼筛法
     * 核心思想是给出要筛选数值的范围 n，
     * 找出 √𝑛 以内的素数 p1, p2..., p𝑘。
     * 先用 2 去筛，即把 2 留下，把 2 的倍数剔除掉；
     * 再用下一个素数，也就是 3 筛，把 3 留下，把 3 的倍数剔除掉；
     * 接下去用下一个素数 5 筛，把 5 留下，把 5 的倍数剔除掉；
     * 不断重复下去……
     */
    public static int countPrimes1(int n) {
        boolean[] isPrim = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {
            //只用考虑sqrt(n)的范围即可
            if (isPrim[i]) {
                // i 的倍数不可能是素数了
                for (int j = i * 2; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                num++;
            }
        }
        return num;
    }

    /**
     * 一般方法 时间复杂度较高
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int num = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                num++;
            }
        }
        return num;
    }

    /**
     * 判断一个数是否为质数
     */
    public static boolean isPrime(int a) {
        double sqrt = Math.sqrt(a);
        if (a < 2) {
            return false;
        }
        if (a == 2 || a == 3) {
            return true;
        }
        if (a % 2 == 0) {// 先判断是否为偶数，若偶数就直接结束程序
            return false;
        }
        for (int i = 3; i <= sqrt; i += 2) {
            //以2步进，偶数不可能是质数
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
