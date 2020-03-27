package algorithm.sortProblem.exchange;

import util.MyUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序的性能取决于划分是否平衡（划分的元素是否平衡）
 * 最坏情况：输入本身是倒排序好的或者基本上倒排好的，那么子问题就是变成了T(0)和T(n-1) --> T(n) = T(0) + T(n-1) + Θ(n) =  O(n²) （等差级数）
 * 最好情况：输入本身非常平衡，两个子问题的规模恰好是T(n/2)和T(n/2-1)（-1是减pivot），T(n) = 2T(n/2)+Θ(n) = O(nlgn)
 * 平均情况：（只要输入划分是常数比例划分，那么产生的递归树深度都为lgn，每层代价为n）接近于最好情况，T(n) = O(nlgn)，详细分析见算法导论
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/12 15:50
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 1, 6, 3, 7, 9, 8};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 分解：找一个pivot分解原数组，左子组均小于pivot，右子组均大于pivot
     * 解决：分别对左右子组进行递归快排
     * 合并：原址排序不需要合并
     *
     * @param nums
     * @param p
     * @param r
     */
    private static void quickSort(int[] nums, int p, int r) {
        if (p < r) {
            int q = randomPartition(nums, p, r);
            quickSort(nums, p, q - 1);
            quickSort(nums, q + 1, r);
        }
    }

    public static int partition(int[] nums, int p, int q,Integer pivot) {
        if (pivot == null){
            pivot = nums[p];
        }
        int i = p;
        for (int j = p + 1; j <= q; j++) {
            if (nums[j] <= pivot) {
                i++;
                //保证当前面出现了比pivot大的数字的情况下(i++<j)，要把这个数字移动到最右侧去，保证pivot左右的大小
                MyUtil.swap(nums, i, j);
            }
        }
        //把pivot交换到对应位置上去
        MyUtil.swap(nums, p, i);
        return i;
    }

    public static int randomPartition(int[] nums, int p, int q) {
        //随机选择主元
        Random random = new Random();
        int randomPivot = random.nextInt(q - p + 1) + p;
        MyUtil.swap(nums, p, randomPivot);
        return partition(nums, p, q,null);
    }

}
