package setAndmap;

public interface Map<K, V> {

    // 向映射添加元素
    void add(K key, V value);

    // 向映射删除元素
    V remove(K key);

    // 判断映射是否包含指定key
    boolean contains(K key);

    // 根据key获取映射中的value
    V get(K key);

    // 修改映射中key对应的value
    void set(K key, V nnewValue);

    // 获取映射中元素个数
    int getSize();

    // 判断映射是否为空
    boolean isEmpty();

}
