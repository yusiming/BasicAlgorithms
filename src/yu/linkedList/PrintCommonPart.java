package yu.linkedList;

/**
 * 打印两个有序链表的公共部分
 *
 * @Auther yusiming
 * @Date 2019/2/20 10:20
 */
public class PrintCommonPart {
    private static class Node {
        Node next;
        int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

        public Node(int value) {
            this(null, value);
        }
    }

    public static void print(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return;
        }
        while (head1 != null && head2 != null) {
            if (head1.value == head2.value) {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.value < head2.value) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        print(node1, node2);
    }
}
