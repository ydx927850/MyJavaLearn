package algorithm.arrayProblem;

public class ReversePairs {
    static int cnt = 0;
    public static int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return cnt;
    }

    public static void mergeSort(int[] nums,int start,int end){
        if(start<end){
            int mid = start + (end-start)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }

    public static void merge(int[] nums,int start,int mid,int end){
        int[] tmp = new int[end-start+1];
        int p1 = start;
        int p2 = mid+1;
        int i = 0;
        while(p1<=mid && p2<=end){
            if(nums[p1]<=nums[p2]){
                tmp[i] = nums[p1];
                p1++;
            }else{
                tmp[i] = nums[p2];
                p2++;
                //这里统计逆序对数目,当前一个数组的当前值大于后面的当前值时，那么逆序对的数量就是前面数组剩余的个数（因为前面的数组已经升序排序好了，后面的一定比前面的大）
                cnt += (mid-p1+1);
            }
            i++;
        }
        while(p1<=mid){
            tmp[i++] = nums[p1++];
        }
        while(p2<=end){
            tmp[i++] = nums[p2++];
        }
        if (tmp.length >= 0) System.arraycopy(tmp, 0, nums, start, tmp.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7};
        int i = reversePairs(nums);
        System.out.println(i);
    }
}
