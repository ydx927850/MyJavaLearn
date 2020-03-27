package algorithm.bitProblem;


/**
 * 找出序列中缺失的数字
 * 辅助数组/位运算
 * @author Yandx
 * @version 1.0
 * @date created on 2019/11/27 11:22
 */
public class MissingNumber {
    private static int missingNumber(int[] nums) {
        int[] help = new int[nums.length + 1];
        for (int i : help) {
            help[i] = 0;
        }
        for (int num : nums) {
            help[num] = 1;
        }
        for (int i=0;i<help.length;i++) {
            if (help[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private static int missingNumber1(int[] nums){
        int missing = nums.length;
        for (int i=0;i<nums.length;i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1};
        System.out.println(missingNumber(nums));
    }
}
