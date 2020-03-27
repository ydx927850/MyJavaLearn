package algorithm.designProblem;

import java.util.LinkedList;
import java.util.Queue;

public class FirstAppearingOnce {
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
            queue.poll();
    }

    public char firstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }

    public static void main(String[] args) {
        FirstAppearingOnce firstAppearingOnce = new FirstAppearingOnce();
        firstAppearingOnce.insert('g');
        firstAppearingOnce.insert('o');
        firstAppearingOnce.insert('o');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
    }

}
