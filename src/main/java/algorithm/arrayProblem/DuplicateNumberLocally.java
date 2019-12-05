package algorithm.arrayProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 不修改数组找出任意一个重复的数字
 * 长度为n+1的数组，里面的数字在1-n范围内，也就是说至少有一个重复的
 */
public class DuplicateNumberLocally {
    /**
     * 使用辅助数组/map来实现
     */
    public static void duplicateNumberLocally1(int[] nums) {
        DuplicateNumber.duplicateNumber2(nums);
    }

    /**
     * 使用二分查找的思想，用空间换时间
     * 如果1-n范围内数字的总数比n大，那说明有重复
     * 把1~n的数字从中间的数字middle分为两部分，
     * 统计输入数组中1~middle的数字的数目，如果这部分数目大于middle，则说明此部分中含有重复数字，否则就是另外的一部分含有重复数字。
     * 依此类推，将区间内的数目和区间大小比较，直到区间的头尾相等，就找到了重复数字。
     * 有弊端，不能找出所有的重复数字
     * 二分法，countRange被调用lgn次，总时间复杂度O(nlgn)
     */
    public static void duplicateNumberLocally2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int low = 1;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            int count = countRange(nums, low, mid);
            if (low == high) {
                if (count > 1) {
                    System.out.println(low);
                    break;
                }else{
                    break;
                }
            }
            if (count > (mid - low + 1)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
    }

    private static int countRange(int[] nums, int low, int high) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (num >= low && num <= high)
                count++;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        duplicateNumberLocally2(nums);
    }
}
