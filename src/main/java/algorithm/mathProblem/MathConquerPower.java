package algorithm.mathProblem;

/**
 * 乘方问题
 * 使用递归算法解决x^n
 * 将问题划分为:
 * (1)x^(n/2) * x^(n/2) n为偶数
 * (2)x^[(n-1)/2] * x^[(n-1)/2] * x n为奇数
 * 那么问题的规模变为n/2且只有一个子问题,乘法消耗常量的时间
 * 时间复杂度为O(lgn)
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/10 15:03
 */
public class MathConquerPower {
    public static void main(String[] args) {
        System.out.println(mathConquerPower(4, 2));
    }

    private static int mathConquerPower(int n, int x) {
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            //子问题是 (x*x)^(n/2)
            return mathConquerPower(n / 2, x * x);
        } else {
            //子问题是 x*(x*x)^[(n-1)/2]
            return x * mathConquerPower((n - 1) / 2, x * x);
        }
    }
}
