package algorithm.designProblem;

import java.util.Stack;

/**
 * 最小栈问题
 * 除了实现基本的出栈入栈操作
 * 还有实现O(1)的获取栈中最小值的操作
 */
public class MinStackWithHelper {
    Stack<Integer> data;
    Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStackWithHelper() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (!helper.isEmpty()){
            int min = helper.peek();
            if (x<=min){
                helper.push(x);
            }
        }else{
            helper.push(x);
        }
    }

    public void pop() {
        int pop = data.pop();
        if (pop == helper.peek()){
            helper.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}
