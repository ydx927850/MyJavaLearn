package algorithm.arrayProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/10/23 17:19
 */
public class IsValidSudo {

    public static void main(char[][] board) {

    }

    private static boolean isValidSudo(char[][] board) {
        HashMap<Integer,Integer>[] rows = new HashMap[9];
        HashMap<Integer,Integer>[] columns = new HashMap[9];
        HashMap<Integer,Integer>[] subBoxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            subBoxes[i] = new HashMap<>();
        }

        //一次遍历验证行、列、子数独是否满足条件
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value != '.') {
                    //不为空时进行判断，通过在对应的map中设定值来确定该value在行、列、子数独中出现的次数，最后通过次数来进行判断，如果大于1，则返回false
                    int n = (int) value;
                    //行
                    rows[i].put(n, (int) rows[i].getOrDefault(n, 0) + 1);
                    //列
                    columns[j].put(n, (int) columns[j].getOrDefault(n, 0) + 1);
                    //子数独
                    int subBoxIndex = j / 3 + (i / 3) * 3;
                    subBoxes[subBoxIndex].put(n, (int) subBoxes[subBoxIndex].getOrDefault(n, 0) + 1);

                    //次数判断
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || subBoxes[subBoxIndex].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
