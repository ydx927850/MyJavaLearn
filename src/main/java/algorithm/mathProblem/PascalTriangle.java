package algorithm.mathProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成帕斯卡三角形的前n行
 * 帕斯卡三角形中每个位置的值等于它左上角和右上角数字之和
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/11/27 10:25
 */
public class PascalTriangle {
    private static List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> tmp = new ArrayList<>();
            if (i == 1) {
                tmp.add(1);
                res.add(tmp);
            } else {
                List<Integer> integerList = res.get(i - 2);
                int index = 0;
                tmp.add(1);
                for (int j = 1; j < i - 1; j++) {
                    int sum = integerList.get(index)+integerList.get(index+1);
                    tmp.add(sum);
                    index++;
                }
                tmp.add(1);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
