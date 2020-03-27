package algorithm.arrayProblem;


import java.awt.image.Kernel;
import java.util.Arrays;

public class GetNumberOfK {
    public static int getNumberOfK(int [] array , int k) {
        if(array == null || array.length==0){
            return 0;
        }
        int kIndex = binarySearch(array,k);
        if(kIndex == -1){
            return 0;
        }
        int k1Index = binarySearch(array,k+1);
        if(k1Index == -1){
            return array.length - kIndex;
        }else{
            return k1Index - kIndex;
        }
    }

    private static int binarySearch(int[] array,int k){
        int l = 0;
        int r = array.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(array[mid]>=k){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        if(array[l]!=k){
            return -1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,3,3,4,5};
        System.out.println(getNumberOfK(array,5));
        System.out.println(binarySearch(array,8));
        System.out.println(binarySearch(array,4));
    }

}
