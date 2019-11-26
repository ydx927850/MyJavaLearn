package algorithm.arrayProblem;

import util.MyUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 随机打乱数组
 * 1.暴力解法：
 * 将所有的数放入到一个List中，每次生成随机数并从list里取数字存入，然后将其从list里移除
 * 任意一个数字在第k轮被选中的概率 =  P(e在第 k 轮被选中)) ⋅ P(e在前k轮不被选中) = (1/n-k) ⋅ ∏(n-i)/(n-i+1) = 1/n，因此是等概率的
 * O(n²)
 * <p>
 * 2.Fisher-Yates 洗牌算法
 * 在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。接下来，将当前元素和随机选出的下标所指的元素互相交换
 * O(n)
 * 简单验证如下：
 * 每次迭代取值的可能为n-k+1种 --> 总共的可能为n！，符合条件
 * 具体可以采用蒙特卡洛方法验证（大力出奇迹）
 * @author Yandx
 * @version 1.0
 * @date created on 2019/11/19 8:29
 */
public class ShuffleArray {
    private int[] original;
    private int[] tmp;
    private Random random = new Random();

    public ShuffleArray(int[] nums) {
        tmp = nums;
        original = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        List<Integer> indexList = new ArrayList<>();
        for (int value : tmp) {
            indexList.add(value);
        }
        for (int j = 0; j < tmp.length; j++) {
            int index = random.nextInt(indexList.size());
            tmp[j] = indexList.get(index);
            indexList.remove(index);
        }
        return tmp;
    }

    public int[] shuffle1() {
        for (int j = 0; j < tmp.length; j++) {
            MyUtil.swap(tmp, j, random.nextInt(tmp.length));
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5,};
        ShuffleArray shuffleArray = new ShuffleArray(nums);
        System.out.println(Arrays.toString(shuffleArray.shuffle()));
        System.out.println(Arrays.toString(shuffleArray.reset()));
    }
}
