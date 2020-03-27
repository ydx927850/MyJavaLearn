package algorithm.sortProblem.linear;

import util.MyUtil;

import java.util.Arrays;

public class RadixSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{21,45,66,22,5,7,8,1,185};
        radixSort(arr,3);
        System.out.println(Arrays.toString(arr));
    }
    public static void radixSort(int[] arr,int maxDigit){
        int[] count = new int[10];
        int[] bucket = new int[arr.length];
        for(int k=1;k<=maxDigit;k++){
            Arrays.fill(count,0);
            for(int num:arr){
                int d = MyUtil.getDigit(num,k);
                count[d]++;
            }
            for(int i=1;i<count.length;i++){
                count[i] = count[i]+count[i-1];
            }
            for(int i=arr.length-1;i>=0;i--){
                int d = MyUtil.getDigit(arr[i],k);
                bucket[count[d]-1] = arr[i];
                count[d]--;
            }
            System.arraycopy(bucket,0,arr,0,arr.length);
        }

    }
}
