package yu.CatDogQueue;

/**
 * 包装类
 *
 * @Auther yusiming
 * @Date 2019/2/19 11:23
 */
public class PetWrapper {
    private Pet pet;
    private long count;

    public PetWrapper(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }
}
