package algorithm.arrayProblem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/10/20 11:14
 */
public class SingleNumber {
    private static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int count = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
            count++;
            map.put(nums[i], count);
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if ((Integer) entry.getValue() == 1) {
                return (Integer) entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = singleNumber(new int[]{2, 2, 6, 4, 4, 5, 5});
        System.out.println(i);
    }
}
