package algorithm.arrayProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoNumSum {
    public static List<Integer> findNumbersWithSum(int [] array, int sum) {
        Map<Integer,Integer> map = new HashMap();
        List<Integer> res = new ArrayList();
        for(int i=0;i<array.length;i++){
            map.put(array[i],i);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++){
            int a = array[i];
            int b = sum-a;
            int index = map.getOrDefault(b,-1);
            if(index!=-1 && index!=i){
                int c = a*b;
                if(c<min){
                    min = c;
                    res.clear();
                    res.add(a);
                    res.add(b);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,7,11,15};
        List<Integer> numbersWithSum = findNumbersWithSum(array, 15);
        System.out.println(numbersWithSum);
    }
}
