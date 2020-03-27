package algorithm.sortProblem.exchange;

import util.MyUtil;

import java.util.Arrays;
import java.util.Comparator;

public class HeapSortTest {
    static int heapIndex;
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,1,8,4,4,6,9,9,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        buildMaxHeap(arr);
        for(int i=arr.length-1;i>=0;i--) {
            MyUtil.swap(arr, i, 0);
            heapIndex--;
            containsMaxHeap(arr,0);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        heapIndex = arr.length-1;
        for(int i=arr.length/2-1;i>=0;i--){
            containsMaxHeap(arr,i);
        }
    }

    private static void containsMaxHeap(int[] arr,int root){
        int largest;
        int left = left(root);
        int right = right(root);
        if(left<=heapIndex && arr[left]>arr[root]){
            largest = left;
        }else{
            largest = root;
        }
        if(right<=heapIndex && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest!=root){
            MyUtil.swap(arr,largest,root);
            containsMaxHeap(arr,largest);
        }
    }

    private static int left(int root){
        return root*2+1;
    }
    private static int right(int root){
        return root*2+2;
    }
}
