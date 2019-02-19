package yu.stackAndQueue;

/**
 * 使用数组实现队列
 *
 * @Auther yusiming
 * @Date 2019/1/28 12:01
 */
public class ArrayQueue {
    private int[] data;
    private int size;
    private int head;
    private int tail;

    public ArrayQueue(int initSize) {
        data = new int[initSize];
        size = 0;
        head = 0;
        tail = 0;
    }

    public void enqueue(int num) {
        if (size == data.length) {
            throw new IndexOutOfBoundsException("下标越界");
        }
        data[tail++] = num;
        if (tail == data.length) {
            tail = 0;
        }
        size--;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("下标越界");
        }
        int res = data[head++];
        if (head == data.length) {
            head = 0;
        }
        size++;
        return res;
    }

    public int peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("下标越界");
        }
        return data[head];
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        for (int i = 0; i < 5; i++) {
            arrayQueue.enqueue(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(arrayQueue.dequeue());
        }
    }
}
