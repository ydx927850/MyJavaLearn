package algorithm.arrayProblem;

import java.util.Arrays;

/**
 * 求解最大子数组(最大化收益)
 * 假设我们需要求数组A的最大子数组，采用分治法的方法来实现
 * 将数组分为两个子数组，那么问题就转换为了三个问题（A的最大子数组只会出现在A[low,mid]/A[low,mid,high]/A[mid+1,high]这三种里面）：
 * （1）求A[low,mid]的最大子数组
 * （2）求A[mid,high]的最大子数组
 * （3）求数组中跨越中点mid的最大子数组
 * 前两个问题递归求解即可，第三个问题则是简单的线性循环即可
 * 时间复杂度：O（nlgn）
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/4 14:39
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] nums1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(findMaxSubArrayRes(nums1));
//        int[] maxSubArray = findMaxSubArray(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(maxSubArray));
    }


    private static int findMaxSubArrayRes(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int k=0;
        for(int j=1;j<dp.length;j++){
            if(dp[j]>dp[k]){
                k = j;
            }
        }
        return dp[k];
    }

    private static int findMaxSubArrayRes2(int[] nums){
        int res = nums[0];
        int sum = 0;
        for(int num:nums){
            if (sum>0){
                sum += num;
            }else{
                sum = num;
            }
            res = Math.max(sum,res);
        }
        return res;
    }

    /**
     * 递归查找最大子数组
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int[] findMaxSubArray(int[] nums, int low, int high) {
        if (low == high) {
            return new int[]{low, high, nums[low]};
        }
        int mid = (low + high) / 2;
        int[] left;
        int[] right;
        int[] cross;
        //左侧递归
        left = findMaxSubArray(nums, low, mid);
        //右侧递归
        right = findMaxSubArray(nums, mid + 1, high);
        //跨越中点的最大子数组
        cross = findMaxCrossArray(nums, low, mid, high);
        if (left[2] >= right[2] && left[2] >= cross[2]) {
            return left;
        } else if (right[2] >= left[2] && right[2] >= cross[2]) {
            return right;
        } else {
            return cross;
        }
    }

    /**
     * 寻找跨越中点的最大子数组 --> 左子列最大的数组和+右子列最大的数组和
     *
     * @return
     */
    private static int[] findMaxCrossArray(int[] nums, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum1 = 0;
        int maxLeft = 0;
        //左子列
        for (int i = mid; i >= low; i--) {
            sum1 = sum1 + nums[i];
            if (sum1 > leftSum) {
                leftSum = sum1;
                maxLeft = i;
            }
        }
        //右子列
        int rightSum = Integer.MIN_VALUE;
        int sum2 = 0;
        int maxRight = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum2 = sum2 + nums[i];
            if (sum2 > rightSum) {
                rightSum = sum2;
                maxRight = i;
            }
        }
        int[] result = new int[3];
        result[0] = maxLeft;
        result[1] = maxRight;
        result[2] = leftSum + rightSum;
        return result;
    }
}
