package algorithm.arrayProblem;

public class MergeTwoSortedArray {
    public static void main(String[] args) {

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while(p1>=0 && p2>=0){
            if(nums2[p2]>nums1[p1]){
                nums1[p] = nums2[p2];
                p2--;
                p--;
            }else{
                nums1[p] = nums1[p1];
                p1--;
                p--;
            }
        }
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }
}
