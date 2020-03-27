package algorithm.dynamicProgram;

/**
 * 最长公共子序列问题
 * 两个字符串s1和s2，求他们的公共子序列（子序列不要求字符必须连续）
 * babcde & ace == ace
 */
public class LongestCommonSubsequence {
    /**
     * 动态规划
     * 假设dp[i][j] 表示第s1[0-i]和s2[0-j]的最长公共子序列
     */
    private static int longestCommonSubsequence(String s1,String s2){
        //假设两个字符串以''空字符串开头，方便初始化dp数组
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<s2.length();j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                //因为首位多加了一个空字符，这里要减一
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] =Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "babcde";
        String s2 = "ace";
        System.out.println(longestCommonSubsequence(s1,s2));
    }
}
