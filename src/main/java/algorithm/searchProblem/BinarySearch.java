package algorithm.searchProblem;

/**
 * 二分查找
 * （1）简单找一个数字
 * （2）找左边界
 * （3）找有边界
 * 注意几点：搜索区间、终止条件、返回值
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/10 14:38
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,4,4,5,6,8,11};
        System.out.println(simpleBinarySearch(nums,4));
        System.out.println(leftBinarySearch(nums,4));
        System.out.println(rightBinarySearch(nums,4));
    }


    private static int simpleBinarySearch(int[] nums, int target) {
        //搜索区间为双端闭区间
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            //终止条件是left = right+1，此时搜索区间为[right+1,right]没有值，可以结束。注意不能是<，不然会漏掉一个
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                //维持闭区间
                left = mid+1;
            }else{
                //维持闭区间
                right = mid-1;
            }
        }
        return -1;
    }

    private static int leftBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                //因为搜索左边界，此时不直接返回，而是将右边界缩进
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        //循环的退出条件是left = right+1，如果直到数组最后都搜索不到，那么left可能会越界
        if(left>=nums.length || nums[left]!=target){
            //返回的值实际上是比指定target元素小的元素个数，两个条件分别对应所有元素都比target小和都比target大（返回0）的情况
            return -1;
        }
        return left;
    }

    private static int rightBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                left = mid+1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(right<0 || nums[right]!=target){
            //如果所有元素都比指定元素大，那么r会到-1终止；如果所有元素都比它小，r会到length-1（可能相等，也可能不等）
            return -1;
        }
        return right;

    }
}
