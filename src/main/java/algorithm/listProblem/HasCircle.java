package algorithm.listProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/10/31 14:49
 */
public class HasCircle {
    private static boolean hasCircle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        int i=0;
        while(head!=null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
