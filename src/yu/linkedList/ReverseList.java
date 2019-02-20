package yu.linkedList;

/**
 * 反转单向链表和双向链表
 *
 * @Auther yusiming
 * @Date 2019/2/20 10:32
 */
public class ReverseList {
    private static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 反转单向链表
     *
     * @param head 链表的头节点
     * @return 反转之后的链表的头节点
     */
    public static Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        // 当前节点的下一个节点
        Node next = null;
        // 当前节点的前一个节点
        Node pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static class DoubleNode {
        int value;
        DoubleNode next;
        DoubleNode pre;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 反转双向链表
     *
     * @param head 双向链表的头节点
     * @return 反转之后的双向链表的头节点
     */
    public static DoubleNode reverseList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
