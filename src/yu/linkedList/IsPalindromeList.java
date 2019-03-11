package yu.linkedList;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 *
 * @author yusiming
 * @date 2019/2/20 11:21
 */
public class IsPalindromeList {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 方法一：需要额外的O(N)的空间
     */
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 方法二：需要额外的O(N/2)的空间
     */
    public static boolean isPalindrome2(Node head) {
        // 快指针
        Node fast = head;
        // 慢指针，这里slow的初始值设置为head.next是为了保证当链表的长度为偶数时，
        // slow的位置停留在中间位置的后一个位置上
        Node slow = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时slow来到中间位置
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 方法三：不额外的空间
     */
    public static boolean isPalindrome3(Node head) {
        return false;
    }
}
