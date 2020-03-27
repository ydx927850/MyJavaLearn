package algorithm.designProblem;

import java.util.LinkedList;
import java.util.List;

public class LastRemainingProblem {
    public static int lastRemaining_Solution(int n, int m) {
        if(n==0){
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int begin = 0;
        while(list.size()>1){
            begin = (begin+m-1) % list.size();
            list.remove(begin);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining_Solution(8,3));
    }
}
