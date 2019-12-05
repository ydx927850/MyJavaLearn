package algorithm.arrayProblem;

import org.apache.commons.collections.MapUtils;
import util.MyUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 找出数组中重复的数字
 * 在一个长度为n的数组里，所有的数字都是在0~n-1范围内的，找出数组中重复的数字，可能有多个
 */
public class DuplicateNumber {
    /**
     * 排序后遍历找就行了
     * 时间O(nlgn) 空间O(1)
     */
    public static void duplicateNumber1(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                System.out.println(nums[i]);
            }
        }
    }

    /**
     * 用map来实现
     * 时间O(n) 空间O(n)
     */
    public static void duplicateNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])!=null){
                System.out.println(nums[i]);
            }else{
                map.put(nums[i],1);
            }
        }
    }

    /**
     * 通过交换数组元素来原地查找
     * 遍历数组时，讲该元素和下标作比较，如果不同，则讲该下标的元素和该元素作为下标的值交换
     * 交换前先比较两个数字，如果相同，那么就找到了一个重复
     * 时间O(n) 空间O(1)
     */
    public static void duplicateNumber3(int[] nums){
        for (int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if (nums[i] == nums[nums[i]]){
                    System.out.println(nums[i]);
                    break;
                }
                MyUtil.swap(nums,i,nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 0, 3, 3, 5, 1};
        duplicateNumber3(nums);
    }

}
