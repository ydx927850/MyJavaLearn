package algorithm.designProblem;

import java.util.Stack;

/**
 * 使用一个栈解决最小栈问题
 */
public class SingleMinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> data;

    /** initialize your data structure here. */
    public SingleMinStack() {
        data = new Stack<>();
    }

    public void push(int x) {
        if (x<=min){
            data.push(min);
            min = x;
        }
        data.push(x);
    }

    public void pop() {
        if(data.pop() == min){
            min = data.pop();
        }
        if (min == Integer.MAX_VALUE){
            //此时说明栈已经为空，初始化
            data.clear();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min;
    }
}
