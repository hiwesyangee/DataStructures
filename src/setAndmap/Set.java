package setAndmap;

public interface Set<E> {

    // 向集合添加元素
    void add(E e);

    // 向集合删除元素
    void remove(E e);

    // 判断集合是否包含指定元素
    boolean contains(E e);

    // 获取集合中元素个数
    int getSize();

    // 判断集合是否为空
    boolean isEmpty();
}
