package algorithm.arrayProblem;

/**
 * 寻找两个有序数组的中位数
 * 先合并然后再找中值
 */
public class SearchMidInTwoSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mergeNums = new int[m+n];
        int i=0;
        int j=0;
        int p=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                mergeNums[p] = nums1[i];
                i++;
            }else{
                mergeNums[p] = nums2[j];
                j++;
            }
            p++;
        }
        if(i<nums1.length){
            System.arraycopy(nums1,i,mergeNums,p,m-i);
        }
        if(j<nums2.length){
            System.arraycopy(nums2,j,mergeNums,p,n-j);
        }
        int mid = (m + n)>>1;
        if((m+n)%2 == 0){
            return ((double)mergeNums[mid]+(double)mergeNums[mid-1]) / 2.0;
        }else{
            return (double)mergeNums[mid];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
