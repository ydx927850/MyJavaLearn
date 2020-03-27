package algorithm.dynamicProgram;

/**
 * 最长公共子串问题
 * 思路和最长公共子序列很像，但是子串要求字符串必须连续
 * 因此采用dp[i][j]来表示s[i]和s[j]是否相等
 * 这样最长的公共子串也就是斜对角连续1的长度最长的那个
 * 为了不额外遍历dp数组求最长值，每次更新dp的时候，让res为左上角的值+本次的值即可保留最长值
 */
public class LongestCommonSubString {
    public static int longestCommonSubsequence(String s1,String s2){
        //假设两个字符串以''空字符串开头，方便初始化dp数组
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<s2.length();j++){
            dp[0][j] = 0;
        }
        //记录最大值
        int res = 0;

        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                //因为首位多加了一个空字符，这里要减一
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    //左上角字符加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    //更新最大值
                    res = Math.max(res,dp[i][j]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bcd";
        System.out.println(longestCommonSubsequence(s1,s2));
    }
}
