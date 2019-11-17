package algorithm.dynamicProgram.maxProfit;

/**
 * 使用状态方程解决股票买卖问题
 * dp[i][k][p] --> 第i天，至多还可以进行k次交易时，持有股票状态为p(0:不持有，1：持有)时，最大的利润
 * 对于p=0状态 --> 在卖出股票之后，不持有股票的情况（不包含原本就不持有）
 * <p>
 * base case：
 * dp[-1][k][0] = dp[i][0][0] = 0
 * dp[-1][k][1] = dp[i][0][1] = -infinity
 * <p>
 * 状态转移方程：
 * dp[i][k][0] = max(dp[i-1][k][0] , dp[i-1][k][1] + price[i])
 * dp[i][k][1] = max(dp[i-1][k][1] , dp[i-1][k-1][0] - price[i])
 */
public class MaxProfitProblem {
    public static void main(String[] args) {
        int[] prices = new int[]{2, 1, 4};
        System.out.println(problem3(prices));
    }


    /**
     * 限定只能进行一次交易
     * dp[i][0] = max(dp[i-1][0] , dp[i-1][1] + prices[i])
     * dp[i][1] = max(-prices[i] , dp[i-1][1]) (因为限制交易次数为1，所以说当i-1天卖出后不持有股票时，i天不可再买入，而只能说在i天第一次买入，因此是-prices[i])
     * <p>
     * base case:
     * dp[0][0] = 0;
     * do[0][1] = -prices[0];
     */
    private static int problem1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 不限定交易次数
     * dp[i][0] = max(dp[i-1][0] , dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][0] - prices[i] , dp[i-1][1])  (因为不限制交易次数，所以在i-1天卖出不持有股票后，i天仍然可以购买股票)
     * <p>
     * base case:
     * dp[0][0] = 0;
     * do[0][1] = -prices[0];
     */
    private static int problem2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 不限定交易次数,但是卖出后有一天的冷冻期
     * dp[i][0] = max(dp[i-1][0] , dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-2][0] - prices[i] , dp[i-1][1])  (因为不限制交易次数，所以在i-1天卖出不持有股票后，i天仍然可以购买股票)
     * <p>
     * base case:
     * dp[0][0] = 0;
     * do[0][1] = -prices[0];
     * dp[1][0] = Math.max(0,prices[1]-prices[0]);
     * dp[1][1] = Math.max(-prices[0],-prices[1]);
     */
    private static int problem3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (prices.length == 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 不限定交易次数,但每次交易含手续费
     * 实际上就是买入股票的价格提高fee
     * dp[i][0] = max(dp[i-1][0] , dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][0] - prices[i] - fee , dp[i-1][1])  (因为不限制交易次数，所以在i-1天卖出不持有股票后，i天仍然可以购买股票)
     * <p>
     * base case:
     * dp[0][0] = 0;
     * do[0][1] = -prices[0];
     */
    private static int problem4(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i] - fee, dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 限定交易次数为k次
     */
    private static int problem5(int[] prices, int k) {
        if (prices == null || prices.length == 0) return 0;
        if (k > prices.length / 2) {
            //此时已经变成了不限制次数交易
            return problem2(prices);
        }
        int[][][] dp = new int[prices.length][k+1][2];
        for (int i = 0; i < k + 1; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int k1 = 1; k1 <= k; k1++) {
                dp[i][k1][0] = Math.max(dp[i - 1][k1][0], dp[i - 1][k1][1] + prices[i]);
                dp[i][k1][1] = Math.max(dp[i - 1][k1][1], dp[i - 1][k1-1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }


}
