package linkedlist;

/**
 * 自定义队列接口
 *
 * @param <E>
 */
public interface Queue<E> {
    // 获取队列中元素个数
    int getSize();

    // 判断队列是否为空
    boolean isEmpty();

    // 元素入队
    void enqueue(E e);

    // 元素出队
    E dequeue();

    // 查看队首元素
    E getFront();
}
