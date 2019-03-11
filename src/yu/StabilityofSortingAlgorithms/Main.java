package yu.StabilityofSortingAlgorithms;

import java.util.PriorityQueue;

/**
 * @author yusiming
 * @date 2018/12/21 10:26
 */
public class Main {
    public static void main(String[] args) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>((Student a, Student b) -> a.getId() - b.getId());
        Student a = new Student("yu", 1, 20);
        Student b = new Student("si", 2, 30);
        Student c = new Student("ming", 3, 25);
        priorityQueue.add(a);
        priorityQueue.add(b);
        priorityQueue.add(c);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
