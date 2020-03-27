package algorithm.sortProblem.linear;

import util.MyUtil;

import java.util.Arrays;

/**
 * 基数排序
 * 即按位（从最低位开始到最高位）使用稳定的排序算法进行排序，也是线性时间排序，能够解决计数排序时当n过大时，空间资源消耗过大的问题
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/17 10:35
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] nums = new int[]{21,56,88,195,354,1,39,12,7};
        radixSort(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * max表示是基数排序中数的最大位数 如 356 ->d=3
     */
    private static void radixSort(int[] arr, int max) {
        //count数组用来计数
        int[] count = new int[10];
        //bucket用来当桶（在下面你就理解了什么是桶了），放数据，取数据
        int[] bucket = new int[arr.length];

        //k表示第几位，1代表个位，2代表十位，3代表百位
        for(int k=1;k<=max;k++)
        {
            //把count置空，防止上次循环的数据影响
            Arrays.fill(count,0);
            //分别统计第k位是0,1,2,3,4,5,6,7,8,9的数量
            //以下便称为桶
            //即此循环用来统计每个桶中的数据的数量
            for (int value : arr) {
                count[MyUtil.getDigit(value, k)]++;
            }
            //利用count[i]来确定放置数据的位置
            for(int i=1;i<10;i++)
            {
                count[i] = count[i] + count[i-1];
            }
            //执行完此循环之后的count[i]就是第i个桶右边界的位置
            //利用循环把数据装入各个桶中，注意是从后往前装,一是保证稳定性，二是保证十位往上时如果补了零，此时如果是从前往后，那么前面的反而会到后面去，相对位置就变了
            for(int i=arr.length-1;i>=0;i--)
            {
                int j = MyUtil.getDigit(arr[i],k);
                bucket[count[j]-1] = arr[i];
                count[j]--;
            }
            //将桶中的数据取出来，赋值给arr
            System.arraycopy(bucket,0,arr,0,arr.length);
        }
    }
}
