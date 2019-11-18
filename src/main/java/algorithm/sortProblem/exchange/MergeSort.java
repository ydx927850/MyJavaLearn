package algorithm.sortProblem.exchange;

import java.util.Arrays;

/**
 * 归并排序：
 * 使用分治法实现：
 * （1）将数组拆分成两部分
 * （2）两部分递归使用归并排序排序
 * （3）合并排序好的子数组
 * 通过构建递归树可以得出时间复杂度为：O(nlgn)
 * 空间非原址排序（需要额外的数组空间来进行归并操作）
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/2 17:19
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 5, 1, 6, 2, 5, 7, 9};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            //划分子序列
            int mid = (start + end) / 2;
            //左子列排序
            mergeSort(nums, start, mid);
            //右子列排序
            mergeSort(nums, mid + 1, end);
            //合并
            merge(nums, start, mid, end);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[nums.length];
        //合并的思路是每次从两个子数组的顶端选定一个最小的值放入最终的数组中,最后将没有放完的填在最后
        int p1 = start;
        int p2 = mid + 1;
        //当前左子列的首元素位置是合并后的新数组的首元素，不是从0开始！
        int i = start;
        while (p1 <= mid && p2 <= end) {
            if (nums[p1] >= nums[p2]) {
                tmp[i] = nums[p2];
                p2++;
            } else {
                tmp[i] = nums[p1];
                p1++;
            }
            i++;
        }
        while (p1 <= mid) {
            tmp[i] = nums[p1];
            p1++;
            i++;
        }
        while (p2 <= end) {
            tmp[i] = nums[p2];
            p2++;
            i++;
        }
        //复制回原数组
        System.arraycopy(tmp, start, nums, start, end - start + 1);
    }
}
