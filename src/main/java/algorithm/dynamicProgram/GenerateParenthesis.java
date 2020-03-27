package algorithm.dynamicProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成有效括号
 */
public class GenerateParenthesis {
    /**
     * 生成n对括号的所有有效组合
     */
    public List<String> generateParenthesis(int n){
        List<String> ans = new ArrayList<>();
        helper(ans,"",0,0,n);
        return ans;
    }

    public void helper(List<String> ans,String cur,int left,int right,int max){
        if(cur.length()==max*2){
            //括号字符串长度已满
            ans.add(cur);
            return;
        }
        if(left<max){
            //左括号不满，可以继续加
            helper(ans,cur+"(",left+1,right,max);
        }
        if(right<left){
            //右括号数量比左括号少的时候，才可以加右括号
            helper(ans,cur+")",left,right+1,max);
        }
    }

    public static List<String> generateParenthesis1(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis1(3);
        System.out.println(strings);
    }
}
