package yu.CatDogQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列问题：
 * 实现一种狗猫队列的结构，要求如下：
 * 用户可以调用add方法将cat类或dog类的 实例放入队列中；
 * 用户可以调用pollAll方法，将队列中所有的实例按照进队列 的先后顺序依次弹出；
 * 用户可以调用pollDog方法，将队列中dog类的实例按照 进队列的先后顺序依次弹出；
 * 用户可以调用pollCat方法，将队列中cat类的实 例按照进队列的先后顺序依次弹出；
 * 用户可以调用isEmpty方法，检查队列中是 否还有dog或cat的实例；
 * 用户可以调用isDogEmpty方法，检查队列中是否有dog 类的实例；
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例
 *
 * @author yusiming
 * @date 2019/2/19 11:24
 */
public class CatDogQueue {
    private Queue<PetWrapper> DogQ;
    private Queue<PetWrapper> CatQ;
    private long count;

    public CatDogQueue() {
        DogQ = new LinkedList<>();
        CatQ = new LinkedList<>();
        count = 0;
    }

    public void add(Pet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("参数pet不能为null");
        }
        if ("dog".equals(pet.getPetType())) {
            DogQ.add(new PetWrapper(pet, count++));
        } else {
            CatQ.add(new PetWrapper(pet, count++));
        }
    }

    public Dog pollDog() {
        if (DogQ.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return (Dog) DogQ.poll().getPet();
    }

    public Cat pollCat() {
        if (CatQ.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return (Cat) CatQ.poll().getPet();
    }

    public Pet pollAll() {
        if (!CatQ.isEmpty() && !DogQ.isEmpty()) {
            return CatQ.peek().getCount() > DogQ.peek().getCount() ? CatQ.poll().getPet() : DogQ.poll().getPet();
        } else if (!CatQ.isEmpty()) {
            return CatQ.poll().getPet();
        } else if (!DogQ.isEmpty()) {
            return DogQ.poll().getPet();
        } else {
            throw new RuntimeException("队列为空");
        }
    }
}
