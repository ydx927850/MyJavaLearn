package algorithm.sortProblem.linear;

import java.util.Arrays;

public class CountSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,1,1,4,5,0};
        int[] sort = countSort(arr, 5);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] countSort(int[] arr,int k){
        int[] count = new int[k+1];
        Arrays.fill(count,0);
        for(int num:arr){
            count[num]++;
        }
        for(int i=1;i<count.length;i++){
            count[i] = count[i-1] + count[i];
        }
        int[] res = new int[arr.length];
        for(int num:arr){
            res[count[num]-1] = num;
            count[num]--;
        }
        return res;

    }
}
