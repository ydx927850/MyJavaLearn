package algorithm.designProblem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    public static void main(String[] args) {
        PriorityQueue<Integer> test = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        test.add(1);
        test.add(2);
        System.out.println(test);
    }

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int count;
    public MedianFinder(){
        //o1是新值，o2是旧值
        maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
        minHeap = new PriorityQueue<>();
        count = 0;
    }

    public void addNum(int x){
        count++;
        maxHeap.add(x);
        minHeap.add(maxHeap.poll());
        if(count%2==1){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian(){
        return count%2==1?(double)maxHeap.peek():(double)(maxHeap.peek()+minHeap.peek())/2;
    }
}
