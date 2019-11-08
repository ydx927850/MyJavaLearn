package algorithm.stringProblem;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/10/24 16:34
 */
public class RotateNumber {


    private static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int value = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && value > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && value < -8)) {
                return 0;
            }
            res = res * 10 + value;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
