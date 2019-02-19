package yu.stackAndQueue;

/**
 * 使用数组实现栈
 *
 * @Auther yusiming
 * @Date 2019/1/28 10:46
 */
public class ArrayStack {
    private int[] data;
    private int size;

    public ArrayStack(int initSize) {
        data = new int[initSize];
    }

    public void push(int num) {
        if (size == data.length) {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
        data[size++] = num;
    }

    public int pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
        return data[--size];
    }

    public int peek() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
        return data[size - 1];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }
    }
}
