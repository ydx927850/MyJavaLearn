package algorithm.sortProblem.exchange;

import util.MyUtil;

import java.util.Arrays;
import java.util.Random;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,5,3,1,6,8,7,9};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int pivot = randomPartition(arr,left,right);
            quickSort(arr,left,pivot-1);
            quickSort(arr,pivot+1,right);
        }
    }

    public static int randomPartition(int[] arr,int left,int right){
        Random random = new Random();
        int tmp = random.nextInt(right - left + 1) + left;
        MyUtil.swap(arr,left,tmp);
        return partition(arr,left,right);
    }

    private static int partition(int[] arr,int left,int right){
        int pivot = arr[left];
        int i=left;
        for(int j=i+1;j<=right;j++){
            if(arr[j]<=pivot){
                i++;
                MyUtil.swap(arr,i,j);
            }
        }
        MyUtil.swap(arr,left,i);
        return i;
    }
}
