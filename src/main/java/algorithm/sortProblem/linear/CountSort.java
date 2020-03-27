package algorithm.sortProblem.linear;

import java.util.Arrays;

/**
 * 计数排序
 * 不是基于比较的排序，时间复杂度低，当k渐进趋进n时，T(n) = O(n)
 * 但是需要额外的数组空间来计数
 * 重要性质是其稳定性，当存在相同元素时，他们会根据输入顺序出现在输出数组中
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/16 14:25
 */
public class CountSort {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        int[] result = new int[8];
        countSort(nums, result, 5);
        System.out.println(Arrays.toString(result));
    }

    private static void countSort(int[] nums, int[] out, int k) {
        //k是元素范围上限
        int[] tmp = new int[k + 1];
        //tmp是临时数组，用来存储对应元素在数组中小于等于它的个数
        for (int i = 0; i <= k; i++) {
            tmp[i] = 0;
        }
        for (int num : nums) {
            //计数，获得待排序数组中等于j值的元素个数
            tmp[num] = tmp[num] + 1;
        }
        for (int i = 1; i < tmp.length; i++) {
            //现在临时数组中每个i位置存储的就是小于等于i的元素个数
            tmp[i] = tmp[i] + tmp[i - 1];
        }
        //计数排序，根据临时数组中的计数，把对应的元素放入输出数组中正确的位置,要从后往前遍历才能保持相对顺序
        for (int i=nums.length-1;i>=0;i--) {
            int num = nums[i];
            out[tmp[num] - 1] = num;
            tmp[num]--;
        }
    }

}
