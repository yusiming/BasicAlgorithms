package yu.sort.heapSort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yusiming
 * @date 2019/1/26 11:21
 */
public class MediamQuick {
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());

    public static Double getMedian() {
        if (maxHeap.isEmpty()) {
            return null;
        }
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek() + 0.0;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek() + 0.0;
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    private static void modifyHeapSize() {
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.add(maxHeap.poll());
            return;
        }
        if (minHeap.size() == maxHeap.size() + 2) {
            maxHeap.add(minHeap.poll());
        }
    }

    private static void addNumber(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if (maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        modifyHeapSize();
    }

    private static class MinHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    private static class MaxHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        MediamSlow mediamSlow = new MediamSlow();
        MediamQuick mediamQuick = new MediamQuick();
        int size = 10;
        for (int i = 0; i < 100000; i++) {
            int num = (int) ((size + 1) * Math.random() - (size + 1) * Math.random());
            mediamSlow.addNumber(num);
            mediamQuick.addNumber(num);
            if (!mediamQuick.getMedian().equals(mediamSlow.getMediam())) {
                System.out.println("failed!");
                System.out.println("right method:" + mediamSlow.getMediam());
                System.out.println("test method:" + mediamQuick.getMedian());
                mediamSlow.printNums();
                break;
            }
        }
        System.out.println("success!");
    }
}


