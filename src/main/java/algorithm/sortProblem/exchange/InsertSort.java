package algorithm.sortProblem.exchange;

import java.util.Arrays;

/**
 * 插入排序：
 * 将数组A的元素A[i]插入到A[1,i-1]的子数组中的合适位置，从而产生排序好的子数组A[1,i]
 * 时间复杂度：
 * 最优（已排序好）时，内层循环不执行，时间复杂度为O(n)
 * 最差（反向排序），O(n²)
 * 空间原址排序
 * 平均情况一般和最差情况差不多 O(n²)
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/2 15:57
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] originalNums = new int[]{5, 3, 4, 2, 6, 1};
        int[] sortNums = insertSort(originalNums);
        System.out.println(Arrays.toString(sortNums));
    }

    public static int[] insertSort(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            return nums;
        } else {
            for (int i = 1; i < length; i++) {
                int key = nums[i];
                int j = i - 1;
                while (j >= 0 && nums[j] > key) {
                    //腾位置
                    nums[j + 1] = nums[j];
                    j--;
                }
                //插入
                nums[j + 1] = key;
            }
        }
        return nums;
    }
}
