package algorithm.searchProblem;

import algorithm.sortProblem.exchange.QuickSort;

/**
 * 从数组中随机挑选第i个顺序统计量（第i小的元素）
 * 通过递归实现
 * 只要数组元素互异，那么期望运行时间为O(n)
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/18 10:58
 */
public class RandomSelect {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 1, 6, 7, 11, 23, 4};
        System.out.println(randomSelect(nums, 0, nums.length - 1, 1));
    }

    private static int randomSelect(int[] nums, int p, int r, int i) {
        if (p == r) {
            //基本情况，数组只有一个数
            return nums[p];
        }
        //调用快排的随机划分算法，划分数组
        int partition = QuickSort.randomPartition(nums, p, r);
        //k表示这个划分元素在子数组的位置
        int k = partition - p + 1;
        if (k == i) {
            return nums[k - 1];
        } else if (i < k) {
            //左侧递归
            return randomSelect(nums, p, partition - 1, i);
        } else {
            //右侧递归，i要减去左侧子数组的个数，才是它在右侧子数组的实际位置
            return randomSelect(nums, partition + 1, r, i - k);
        }
    }

}
