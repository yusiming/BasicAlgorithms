package yu.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用两个队列实现栈结构
 *
 * @author yusiming
 * @date 2019/1/28 13:10
 */
public class TwoQueueStack {
    private Queue<Integer> dataQueue;
    private Queue<Integer> helpQueue;

    public TwoQueueStack() {
        dataQueue = new LinkedList<>();
        helpQueue = new LinkedList<>();
    }

    public void push(Integer num) {
        dataQueue.add(num);
    }

    public Integer pop() {
        if (dataQueue.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        if (dataQueue.size() == 1) {
            return dataQueue.poll();
        }
        while (dataQueue.size() > 1) {
            helpQueue.add(dataQueue.poll());
        }
        int res = dataQueue.poll();
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> tmp = dataQueue;
        dataQueue = helpQueue;
        helpQueue = tmp;
    }

    public Integer peek() {
        if (dataQueue.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        while (dataQueue.size() > 1) {
            helpQueue.add(dataQueue.poll());
        }
        int res = dataQueue.poll();
        swap();
        return res;
    }
}
