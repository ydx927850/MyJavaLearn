package algorithm.mathProblem;

/**
 * 判断一个数是否为3的幂
 * 循环和递归最简单
 * 3 ^ log3(MaxInt) = 1162261467
 * MaxInt = 2^32/2 −1 ,因为我们使用 32 位来表示数字，所以范围的一半用于负数(/2)，0 是正数的一部分(-1)。
 * 3是质数，所以3的幂一定是1162261467的除数
 */
public class IsPowerOfThree {
    private static boolean isPowerOfThree(int num){
        return num > 0 && 1162261467 % num == 0;
    }

    private static boolean isPowerOfThree1(int n){
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        return isPowerOfThree(n/3) && n%3==0;
    }
}
