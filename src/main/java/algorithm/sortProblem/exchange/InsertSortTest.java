package algorithm.sortProblem.exchange;

import java.util.Arrays;

public class InsertSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,5,3,6,7,9,8,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        if(arr.length!=0 && arr.length!=1){
            for(int i=1;i<arr.length;i++){
                int key = arr[i];
                int j=i-1;
                while(j>=0 && arr[j]>key){
                    arr[j+1] = arr[j];
                    j--;
                }
                arr[j+1] = key;
            }
        }
    }
}
