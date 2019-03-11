package yu.stackAndQueue;

import java.util.Stack;

/**
 * 使用两个栈实现队列结构
 *
 * @author yusiming
 * @date 2019/1/28 13:30
 */
public class TwoStackQueue {
    private Stack<Integer> dataStack;
    private Stack<Integer> helpStack;

    public TwoStackQueue() {
        dataStack = new Stack<>();
        helpStack = new Stack<>();
    }

    public void enqueue(Integer num) {
        dataStack.add(num);
    }

    public Integer dequeue() {
        if (helpStack.isEmpty() && dataStack.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        if (helpStack.isEmpty()) {
            while (!dataStack.isEmpty()) {
                helpStack.push(dataStack.pop());
            }
        }
        return helpStack.pop();
    }

    public Integer peek() {
        if (helpStack.isEmpty() && dataStack.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        if (helpStack.isEmpty()) {
            while (!dataStack.isEmpty()) {
                helpStack.push(dataStack.pop());
            }
        }
        return helpStack.peek();
    }
}
