package yu.stackAndQueue;

import java.util.Stack;

/**
 * 最小元素栈：
 * 实现一个特殊的栈， 在实现栈的基本功能的基础上， 再实现返回栈中最小元素的操作。
 *
 * @author yusiming
 * @date 2019/1/28 12:42
 */
public class GetMinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public GetMinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(Integer num) {
        if (minStack.isEmpty()) {
            minStack.push(num);
            return;
        }
        if (num <= minStack.peek()) {
            minStack.push(num);
        } else {
            minStack.push(minStack.peek());
        }
        dataStack.push(num);
    }

    public Integer pop() {
        minStack.pop();
        return dataStack.pop();
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinStack stack = new GetMinStack();
        int[] arr = new int[]{7, 4, 6, 3, 5, 1};
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            System.out.println("min:" + stack.getMin());
        }
    }
}
