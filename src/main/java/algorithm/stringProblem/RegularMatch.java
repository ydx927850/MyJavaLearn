package algorithm.stringProblem;

import java.util.Arrays;

/**
 * 实现支持正则表达式 . *的匹配
 * 动态规划
 */
public class RegularMatch {
    public static boolean isMatch(String s,String p){
        if(s==null || p==null){
            return false;
        }
        s = " "+s;
        p = " "+p;
        //给字符串首位加一个空位来处理（""和"c*"的情况)，常用方法！
        //dp[i][j]表示s的前i个字符和p的前j个字符匹配
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<p.length()+1;j++){
                //因为多加了空字符，所以这里减一表示原本的第一个字符,注意字符串的原索引和dp的索引要区分开
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    if(s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2)!='.'){
                        //回溯到前两位（ab,abc*）可以看做匹配了0次c
                        dp[i][j] = dp[i][j-2];
                    }else{
                        //分别表示(s串多加相同字符且上一次匹配 ###bb和###b*)
                        //*表示1个(###b和###b*)
                        //*表示0个(###a和###ab*)
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String a = "aab";
        String b = "c*a*b";
        System.out.println(isMatch(a,b));
    }
}
