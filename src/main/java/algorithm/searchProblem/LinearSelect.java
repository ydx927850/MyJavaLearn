package algorithm.searchProblem;

import algorithm.sortProblem.exchange.InsertSort;
import algorithm.sortProblem.exchange.QuickSort;

import java.util.HashMap;
import java.util.Map;

/**
 * 线性时间选择统计量的算法
 * 与随机选择不同的是其采用的确定的划分算法，同时将主元作为参数传入
 * 首先把数组每5个元素划分为1组，求这每一组的中位数，然后以这些中位数的中位数作为主元划分数组
 * 之后对左右子数组进行递归即可
 * 最坏情况时间复杂度：T(n) = O(n)
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/18 11:20
 */
public class LinearSelect {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 1, 6, 8, 7, 9, 12, 32, 33, 52, 56};
        linearSelect(nums, 0, nums.length - 1, 2);
    }

    private static int linearSelect(int[] nums, int p, int r, int i) {
        if (p == r) {
            return nums[p];
        }
        //子数组个数，每5个元素拆分为一个数组
        int subArrNum = (int) Math.ceil(nums.length / 5);
        Map<Integer, int[]> subArrMap = new HashMap<>();
        int[] subArr = new int[5];
        int index = 1;
        if (subArrNum > 1) {
            for (int start = 0; start + 5 < nums.length; start = start + 5) {
                System.arraycopy(nums, start, subArr, 0, 5);
                subArrMap.put(index, subArr);
                index++;
            }
        }
        //对每个子数组进行排序,获取其中位数组成新的中位数数组
        int[] medianArr = new int[subArrNum];
        for (int j = 1; j <= subArrNum; j++) {
            int[] arr = subArrMap.get(j);
            InsertSort.insertSort(arr);
            medianArr[j - 1] = arr[3];
        }
        //查找中位数数组的中位数作为pivot
        int pivot = linearSelect(medianArr, 0, medianArr.length - 1, medianArr.length / 2);
        //使用查找好的pivot作为partition的元划分数组进行递归搜索即可
        int partition = QuickSort.partition(nums, p, r, pivot);
        //k表示这个划分元素在子数组的位置
        int k = partition - p + 1;
        if (k == i) {
            return nums[k - 1];
        } else if (i < k) {
            //左侧递归
            return linearSelect(nums, p, partition - 1, i);
        } else {
            //右侧递归，i要减去左侧子数组的个数，才是它在右侧子数组的实际位置
            return linearSelect(nums, partition + 1, r, i - k);
        }
    }
}
