package yu.hash;

import java.util.HashMap;

/**
 * 设计一种结构，在该结构中有如下三个功能：
 * insert(key)：将某个key加入到该结构，做到不重复加入。
 * delete(key)：将原本在结构中的某个key移除。
 * getRandom()： 等概率随机返回结构中的任何一个key。
 *
 * @Auther yusiming
 * @Date 2019/2/27 14:52
 */
public class RandomPool<T> {
    private HashMap<T, Integer> h1;
    private HashMap<Integer, T> h2;
    private int size;

    public RandomPool() {
        h1 = new HashMap<>();
        h2 = new HashMap<>();
        size = 0;
    }

    public void insert(T key) {
        if (!h1.containsKey(key)) {
            return;
        }
        h1.put(key, size);
        h2.put(size++, key);
    }

    public T getRandom() {
        if (size == 0) {
            return null;
        }
        int index = (int) (Math.random() * size);
        return h2.get(index);
    }

    public void delete(T key) {
        if (!h1.containsKey(key)) {
            return;
        }
        Integer index = h1.get(key);
        // 这里将结构的长度-1，并且得到最后一个key的索引
        int lastIndex = --size;
        T t = h2.get(lastIndex);
        h2.put(index, t);
        h2.remove(lastIndex);
        h1.remove(key);
        h1.put(t, index);
    }
}
