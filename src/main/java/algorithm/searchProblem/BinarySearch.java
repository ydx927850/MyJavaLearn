package algorithm.searchProblem;

/**
 * 二分查找
 * 取递增排序好的数组的中间值和待查找数比较，小取后，大取前，递归实现
 * 子问题规模为n/2,子问题可以简化为1个（每次只用在一侧递归），比较消耗常数的时间 Θ(1)
 * 时间复杂度：O(lgn)
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/10 14:38
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,5,6,8,11};
        System.out.println(binarySearch(0,nums.length-1,nums,7));
    }


    private static int binarySearch(int start, int end, int[] nums, int target) {
        int half = (start + end) / 2;
        if (target < nums[start] || target > nums[end] || start > end) {
            return -1;
        }
        if (target == nums[half]) {
            return half;
        } else if (target > nums[half]) {
            return binarySearch(half + 1,end,nums,target);
        }else{
            return binarySearch(start,half-1,nums,target);
        }
    }
}
