package algorithm.stringProblem;

public class FindNthDigit {
    public static int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int base = 9;
        int digit = 1;
        //求n是几位数(digit)
        while (n - base * digit > 0) {
            n = n - base * digit;
            base *= 10;
            digit++;
        }
        //此时n表示目标数是digit位数区间的第n位
        //a表示是当前区间的第几个数
        int a = (n - 1) / digit + 1;
        int b = (n % digit == 0) ? digit : n % digit;
        //求具体是哪个数
        int num = (int) Math.pow(10, digit - 1) + a - 1;
        String s = String.valueOf(num);
        return s.charAt(b-1) - '0';
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(201));
    }
}
