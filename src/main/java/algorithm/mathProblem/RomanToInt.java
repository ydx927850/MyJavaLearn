package algorithm.mathProblem;

/**
 * 罗马数转整数
 * I --> 1；V --> 5；X --> 10；L --> 50；C --> 100；D --> 500；M --> 1000
 */
public class RomanToInt {
    private static int romanToInt(String s) {
        int[] values = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    values[i] = 1;
                    break;
                case 'V':
                    values[i] = 5;
                    break;
                case 'X':
                    values[i] = 10;
                    break;
                case 'L':
                    values[i] = 50;
                    break;
                case 'C':
                    values[i] = 100;
                    break;
                case 'D':
                    values[i] = 500;
                    break;
                case 'M':
                    values[i] = 1000;
                    break;
            }
        }
        //计算值
        int i = 0;
        for (; i < values.length - 1; i++) {
            if (values[i] < values[i + 1]) {
                res -= values[i];
            } else {
                res += values[i];
            }
        }
        return res + values[values.length - 1];
    }
}
