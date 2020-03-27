package algorithm.sortProblem.exchange;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,6,1,5,7,6,8,9};
        mergerSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergerSort(int[] arr,int start,int end){
        if(start<end){
            int mid = start+(end-start)/2;
            mergerSort(arr,start,mid);
            mergerSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }

    public static void merge(int[] arr,int start,int mid,int end){
        //这里主要不要用arr的整个数组长度，不然资源利用率太低
        int[] tmp = new int[end-start+1];
        int p1 = start;
        int p2 = mid+1;
        int i=0;
        while(p1<=mid && p2<=end){
            if(arr[p1]>=arr[p2]){
                tmp[i] = arr[p2];
                i++;
                p2++;
            }else{
                tmp[i] = arr[p1];
                i++;
                p1++;
            }
        }
        while(p1<=mid){
            tmp[i] = arr[p1];
            i++;
            p1++;
        }
        while(p2<=end){
            tmp[i] = arr[p2];
            i++;
            p2++;
        }
        System.arraycopy(tmp,0,arr,start,tmp.length);
    }
}
