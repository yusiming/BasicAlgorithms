package yu.sort.heapSort;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 中位数问题的绝对正确的解答
 *
 * @Auther yusiming
 * @Date 2019/1/26 11:42
 */
public class MediamSlow {
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void addNumber(int num) {
        list.add(num);
    }

    public Double getMediam() {
        if (list.isEmpty()) {
            return null;
        }
        list.sort(new MyComparator());
        if (list.size() % 2 == 0) {
            return ((list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0);
        } else {
            return list.get(list.size() / 2) + 0.0;
        }
    }

    private static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public void printNums() {
        System.out.println(list);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        MediamSlow mediamSlow = new MediamSlow();
        for (int i = 0; i < nums.length; i++) {
            mediamSlow.addNumber(nums[i]);
            System.out.println(mediamSlow.getMediam());
        }
    }
}
