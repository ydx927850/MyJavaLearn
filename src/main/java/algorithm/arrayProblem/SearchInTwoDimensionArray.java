package algorithm.arrayProblem;

/**
 * 一个行递增，列也递增的二维数组，输入一个整数，在这个二维数组中查找该整数是否存在
 */
public class SearchInTwoDimensionArray {
    public static boolean searchNum(int[][] nums,int num){
        boolean res = false;
        int row = 0;
        int column = nums[0].length;
        while(row<nums.length && column>0){
            int tmp = nums[row][column-1];
            if (tmp == num){
                res = true;
                break;
            }else if (tmp>num){
                column--;
            }else{
                row++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        boolean searchNum = searchNum(nums, 6);
        System.out.println(searchNum);

    }

}
