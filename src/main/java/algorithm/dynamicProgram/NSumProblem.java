package algorithm.dynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N个骰子的点数概率
 */
public class NSumProblem {
    public static double[] nSum(int n) {
        if(n<1){
            return null;
        }
        int row = n;
        int col = n*6;
        double[][] dp = new double[row][col];
        for(int i=0;i<6;i++){
            //初始化第一行
            dp[0][i] = 1;
        }
        for(int r=1;r<row;r++){
            for(int c=r;c<col;c++){
                for(int k=1;k<=6 && k<=c;k++){
                    dp[r][c] += dp[r-1][c-k];
                }
            }
        }
        List<Double> res = new ArrayList<>();
        double totalNum = Math.pow(6,n);
        for(int i=n-1;i<col;i++){
            res.add(dp[n-1][i]/totalNum);
        }
        double[] ret = new double[res.size()];
        for(int i=0;i<res.size();i++){
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        double[] doubles = nSum(2);
        System.out.println(Arrays.toString(doubles));
    }
}
